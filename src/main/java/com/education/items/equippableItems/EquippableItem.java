package com.education.items.equippableItems;

import com.education.inventory.EquipmentSlot;
import com.education.items.Item;
import com.education.items.ItemRarity;
import com.education.items.StatType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class EquippableItem extends Item {
    private final EquipmentSlot equipmentSlot;
    private final Map<StatType, Integer> bonuses;


    public EquippableItem(String name, int price, ItemRarity rarity, EquipmentSlot equipmentSlot) {
        super(name, price, rarity);
        this.equipmentSlot = equipmentSlot;
        this.bonuses = new HashMap<>();
    }

    protected void addBonus(StatType type, int bonus){
        this.bonuses.put(type, bonus);
    }

    public int getBonus(StatType type){
        return this.bonuses.getOrDefault(type, 0);
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public Map<StatType, Integer> getBonuses() {
        return Collections.unmodifiableMap(bonuses);
    }
}
