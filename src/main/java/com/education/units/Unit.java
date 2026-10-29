package com.education.units;

import com.education.abilities.Ability;
import com.education.core.DamageType;
import com.education.inventory.Equipment;
import com.education.inventory.EquipmentSlot;
import com.education.inventory.Inventory;
import com.education.core.effects.StatusEffect;
import com.education.core.StatType;
import com.education.items.EquippableItem;

import java.util.*;

public abstract class Unit {
    private final UUID id;
    private String name;
    private int currentHealth;
    private int currentMana;
    private final Inventory inventory;
    private final Equipment equipment;
    private final List<StatusEffect> activeStatusEffects;
    private final Map<StatType, Integer> baseStats;
    private final List<Ability> abilities;

    public Unit(String name, Map<StatType, Integer> baseStats) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.currentHealth = baseStats.get(StatType.MAX_HEALTH);
        this.currentMana = baseStats.get(StatType.MAX_MANA);
        this.inventory = new Inventory();
        this.equipment = new Equipment();
        this.activeStatusEffects = new ArrayList<>();
        this.baseStats = baseStats;
        this.abilities = new ArrayList<>();
    }

    public List<String> onTurnStart(){
        updateAbilitiesCooldown();
        return updateStatusEffects();
    }

    public int takeDamage(int damage, DamageType type){
        StatType defenseStat = type.getResistanceStat();
        // If defenseStat is null (True Damage), resistance is 0.
        int resistance = (defenseStat != null)? this.getAllStats().getOrDefault(defenseStat, 0) : 0;
        int actualDamage = type.calculateActualDamage(damage, resistance);
        this.currentHealth = Math.max(0, currentHealth - actualDamage);
        return actualDamage;
    }

    public int spendMana(int amount) {
        currentMana = Math.max(0, currentMana - amount);
        return amount;
    }

    public boolean isEnoughMana(int amount) {
        return currentMana >= amount;
    }

    public boolean isEnoughHealth(int amount) {
        return currentHealth > amount;
    }

    public int heal(int healAmount){
        return currentHealth = Math.min(this.currentHealth + healAmount, this.baseStats.get(StatType.MAX_HEALTH));
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }

    public int getTotalDamage(){
        return this.baseStats.get(StatType.DAMAGE) + this.equipment.getTotalBonus(StatType.DAMAGE) + this.getTotalStatusEffectModifiersBonus(StatType.DAMAGE);
    }

    private List<String> updateStatusEffects(){
        List<String> statusLogs = new ArrayList<>();
        activeStatusEffects.forEach(statusEffect -> {
            List<String> statusEffectsList = statusEffect.processTurn(this);
                    statusLogs.addAll(statusEffectsList);
        }
        );
        statusLogs.addAll(this.removeExpiredStatusEffects());
        return statusLogs;
    }


    public Map<StatType, Integer> getAllStats(){
        Map<StatType, Integer> map = new EnumMap<>(StatType.class);
        for(StatType type : StatType.values()){
            int equipBonus = this.equipment.getTotalBonus(type);
            int activeStatusEffectBonus = getTotalStatusEffectModifiersBonus(type);
            map.put(type, equipBonus + activeStatusEffectBonus + this.baseStats.get(type));
        }
        return map;
    }

    public int getTotalStatusEffectModifiersBonus(StatType type){
        return this.activeStatusEffects.stream().mapToInt((statusEffect -> statusEffect.getModifier(type))).sum();
    }

    public void addStatusEffect(StatusEffect statusEffect){
        this.activeStatusEffects.add(statusEffect);
    }

    private List<String> removeExpiredStatusEffects(){
        List<String> expiredEffectsMessage = new ArrayList<>();
        activeStatusEffects.removeIf(statusEffect -> {
            if (statusEffect.isExpired()) {
                expiredEffectsMessage.add(statusEffect.getName() + " has expired.");
                return true;
            }
            return false;
        });
        return expiredEffectsMessage;
    }

    private void updateAbilitiesCooldown(){
        this.abilities.forEach(Ability::decrementCooldown);
    }

    public void addAbility (Ability ability){
        this.abilities.add(ability);
    }

    public void removeAbility(Ability ability){
        this.abilities.remove(ability);
    }

    public void equip(EquippableItem item){
        if(this.inventory.hasItem(item)){
            this.inventory.removeItem(item);
            if(this.equipment.isSlotTaken(item.getEquipmentSlot())){
                this.inventory.addItem(this.equipment.getItemBySlot(item.getEquipmentSlot()));
            }
            this.equipment.equipItem(item);
        }
        else {
            System.out.println("The item was not found in your inventory.");
        }
    }

    public void unequip (EquipmentSlot slot){
        EquippableItem item = this.equipment.removeItemBySlot(slot);
        if(item != null) {
            this.inventory.addItem(item);
        }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Map<StatType, Integer> getBaseStats() {
        return baseStats;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public List<StatusEffect> getActiveStatusEffects() {
        return activeStatusEffects;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit that = (Unit) o;
        return (Objects.equals(this.id, that.getId()));

    }

    @Override
    public int hashCode (){
        return Objects.hash(this.id);
    }


}
