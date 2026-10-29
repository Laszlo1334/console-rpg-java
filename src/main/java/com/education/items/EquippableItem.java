package com.education.items;

import com.education.inventory.EquipmentSlot;
import com.education.core.StatType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class EquippableItem extends Item {
    private final EquipmentSlot equipmentSlot;
    private final Map<StatType, Integer> bonuses;


    public EquippableItem(String name, int price, ItemRarity rarity, EquipmentSlot equipmentSlot) {
        super(name, price, rarity);
        this.equipmentSlot = equipmentSlot;
        this.bonuses = new EnumMap<>(StatType.class);
    }

    public void addBonus(StatType type, int bonus){
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
