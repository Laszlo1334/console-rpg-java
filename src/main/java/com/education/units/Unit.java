package com.education.units;

import com.education.inventory.Equipment;
import com.education.inventory.EquipmentSlot;
import com.education.inventory.Inventory;
import com.education.items.consumableItems.effects.buff.Buff;
import com.education.items.consumableItems.effects.buff.StatType;
import com.education.items.equippableItems.EquippableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Unit {
    private final UUID id;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int baseDamage;
    private final Inventory inventory;
    private final Equipment equipment;
    private final List<Buff> activeBuffs;

    public Unit(String name, int maxHealth, int baseDamage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.baseDamage = baseDamage;
        this.inventory = new Inventory();
        this.equipment = new Equipment();
        this.activeBuffs = new ArrayList<>();
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
        return currentHealth = Math.min(this.currentHealth + healAmount, maxHealth);
    }
    public boolean isAlive(){
        return currentHealth > 0;
    }
    public int getTotalDamage(){
        int buffsDamage = this.activeBuffs.stream().mapToInt((buff) -> buff.getModifier(StatType.DAMAGE)).sum();
//        for(Buff buff : this.activeBuffs){
//            buffsDamage += buff.getModifier(StatType.DAMAGE);
//        }
        return this.baseDamage + this.equipment.getTotalBonusDamage() + buffsDamage;
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


    public int getBaseDamage() {
        return baseDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public List<Buff> getActiveBuffs() {
        return activeBuffs;
    }

}
