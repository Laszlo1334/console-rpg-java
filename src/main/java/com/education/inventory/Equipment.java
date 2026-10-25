package com.education.inventory;

import com.education.core.StatType;
import com.education.items.equippables.EquippableItem;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

public class Equipment {
    private final UUID id;
    private final Map<EquipmentSlot, EquippableItem> equippedItems;

    public Equipment() {
        this.id = UUID.randomUUID();
        this.equippedItems = new EnumMap<>(EquipmentSlot.class);
    }

    public int getTotalBonus(StatType type){
       return this.equippedItems.values()
               .stream()
               .mapToInt(item -> item.getBonus(type))
               .sum();
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
        return Collections.unmodifiableMap(equippedItems);
    }

}
