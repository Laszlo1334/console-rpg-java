package com.education.inventory;

import com.education.items.EquippableItems.EquippableItem;
import com.education.items.EquippableItems.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Equipment {
    private final UUID id;
    private final Map<EquipmentSlot, EquippableItem> equippedItems;

    public Equipment() {
        this.id = UUID.randomUUID();
        this.equippedItems = new HashMap<>();
    }

    public int getTotalBonusDamage(){
        int totalBonus = 0;
        for(EquippableItem item : this.equippedItems.values()){
            if(item instanceof Weapon){
                Weapon weapon = (Weapon) item;
                totalBonus += weapon.getBonusDamage();
            }
        }
        return totalBonus;
    }

    public EquippableItem removeItemBySlot(EquipmentSlot slot){
        return this.equippedItems.remove(slot);
    }

    public boolean isSlotTaken (EquipmentSlot slot){
        return this.equippedItems.containsKey(slot);
    }

    public EquippableItem getItemBySlot (EquipmentSlot slot){
        return this.equippedItems.get(slot);
    }

    public EquippableItem equipItem (EquippableItem item){
        return this.equippedItems.put(item.getEquipmentSlot(), item);
    }


    public UUID getId() {
        return id;
    }

    public Map<EquipmentSlot, EquippableItem> getEquippedItems() {
        return equippedItems;
    }

}
