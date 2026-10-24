package com.education.items.equippableItems;

import com.education.inventory.EquipmentSlot;
import com.education.items.ItemRarity;
import com.education.items.StatType;

public class Weapon extends EquippableItem {
    public Weapon(String name, int price, ItemRarity rarity, EquipmentSlot slot, int bonusDamage) {
        super(name, price, rarity, slot);
        addBonus(StatType.DAMAGE, bonusDamage);
    }
}
