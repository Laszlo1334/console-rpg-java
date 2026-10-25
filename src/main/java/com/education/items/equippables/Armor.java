package com.education.items.equippables;

import com.education.inventory.EquipmentSlot;
import com.education.items.ItemRarity;
import com.education.core.StatType;

public class Armor extends EquippableItem{
    public Armor(String name, int price, ItemRarity rarity, EquipmentSlot equipmentSlot, int bonusArmor) {
        super(name, price, rarity, equipmentSlot);
        addBonus(StatType.ARMOR, bonusArmor);
    }
}
