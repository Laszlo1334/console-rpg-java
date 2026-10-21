package com.education.items.EquippableItems;

import com.education.inventory.EquipmentSlot;
import com.education.items.ItemRarity;

public class Weapon extends EquippableItem {
    private int bonusDamage;

    public Weapon(String name, int price, ItemRarity rarity, EquipmentSlot slot, int bonusDamage) {
        super(name, price, rarity, slot);
        this.bonusDamage = bonusDamage;
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }
}
