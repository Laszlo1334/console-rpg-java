package com.education.items.equippableItems;

import com.education.inventory.EquipmentSlot;
import com.education.items.ItemRarity;
import com.education.items.StatType;

public class Armor extends EquippableItem{
    public Armor(String name, int price, ItemRarity rarity, EquipmentSlot equipmentSlot, int bonusArmor) {
        super(name, price, rarity, equipmentSlot);
        addBonus(StatType.ARMOR, bonusArmor);
    }
}
