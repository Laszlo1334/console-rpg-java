package com.education.items.equippableItems;

import com.education.inventory.EquipmentSlot;
import com.education.items.Item;
import com.education.items.ItemRarity;

public abstract class EquippableItem extends Item {
    private final EquipmentSlot equipmentSlot;

    public EquippableItem(String name, int price, ItemRarity rarity, EquipmentSlot equipmentSlot) {
        super(name, price, rarity);
        this.equipmentSlot = equipmentSlot;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

}
