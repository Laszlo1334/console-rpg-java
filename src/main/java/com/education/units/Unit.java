package com.education.units;

import com.education.inventory.Equipment;
import com.education.inventory.EquipmentSlot;
import com.education.inventory.Inventory;
import com.education.items.consumableItems.effects.buff.Buff;
import com.education.items.StatType;
import com.education.items.equippableItems.EquippableItem;

import java.util.*;

public abstract class Unit {
    private final UUID id;
    private String name;
    private int currentHealth;
    private final Inventory inventory;
    private final Equipment equipment;
    private final List<Buff> activeBuffs;
    private final Map<StatType, Integer> baseStats;

    public Unit(String name, Map<StatType, Integer> baseStats) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.currentHealth = baseStats.get(StatType.MAX_HEALTH);
        this.inventory = new Inventory();
        this.equipment = new Equipment();
        this.activeBuffs = new ArrayList<>();
        this.baseStats = baseStats;
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

    public int takeDamage(int damage){
        return this.currentHealth = Math.max(0,this.currentHealth - damage);
    }
    public int heal(int healAmount){
        return currentHealth = Math.min(this.currentHealth + healAmount, this.baseStats.get(StatType.MAX_HEALTH));
    }
    public boolean isAlive(){
        return currentHealth > 0;
    }
    public int getTotalDamage(){
        return this.baseStats.get(StatType.DAMAGE) + this.equipment.getTotalBonus(StatType.DAMAGE) + this.getTotalBuffBonus(StatType.DAMAGE);
    }

    public Map<StatType, Integer> getAllStats(){
        Map<StatType, Integer> map = new EnumMap<>(StatType.class);
        for(StatType type : StatType.values()){
            int equipBonus = this.equipment.getTotalBonus(type);
            int activeBuffBonus = getTotalBuffBonus(type);
            map.put(type, equipBonus + activeBuffBonus + this.baseStats.get(type));
        }
        return map;
    }

    public int getTotalBuffBonus (StatType type){
        return this.activeBuffs.stream().mapToInt((buff -> buff.getModifier(type))).sum();
    }

    public void addBuff(Buff buff){
        this.activeBuffs.add(buff);
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

    public List<Buff> getActiveBuffs() {
        return activeBuffs;
    }

}
