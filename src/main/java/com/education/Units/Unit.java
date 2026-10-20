package com.education.Units;

import com.education.Inventory.Equipment;
import com.education.Inventory.Inventory;
import com.education.Items.Weapon;

import java.util.Objects;
import java.util.UUID;

public abstract class Unit {
    private final UUID id;
    private String name;
    private int health;
    private int baseDamage;
    private final Inventory inventory;
    private final Equipment equipment;

    public Unit(String name, int health, int baseDamage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.health = health;
        this.baseDamage = baseDamage;
        this.inventory = new Inventory();
        this.equipment = new Equipment();
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
        return this.health -= damage;
    }
    public int heal(int heal){
        return this.health += heal;
    }
    public boolean isAlive(){
        return health > 0;
    }
    public int getTotalDamage(){
        return this.baseDamage + this.equipment.getTotalBonusDamage();
    }

    public void equip(Weapon weapon){
        if(this.inventory.hasItem(weapon)){
            this.inventory.removeItem(weapon);
            if(this.equipment.getRightHand() != null){
                this.inventory.addItem(this.equipment.getRightHand());
            }
            this.equipment.setRightHand(weapon);
        }
        else {
            System.out.println("The item was not found in your inventory.");
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

    public int getHealth() {
        return health;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

}
