package com.education.units;

import com.education.core.StatType;
import com.education.items.Item;

import java.util.List;
import java.util.Map;

public class Enemy extends Unit{
    private String type;
    private final List<Item> lootableItems;

    public Enemy(String name, String type, Map<StatType, Integer> baseStats, List<Item> lootableItems) {
        super(name, baseStats);
        this.type = type;
        this.lootableItems = lootableItems;


    }

    public List<Item> getLootableItems() {
        return lootableItems;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
