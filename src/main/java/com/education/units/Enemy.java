package com.education.units;

import com.education.core.StatType;
import com.education.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Enemy extends Unit{
    private String type;
    private final List<Item> lootable;

    public Enemy(String name, String type, Map<StatType, Integer> baseStats, List<Item> lootable) {
        super(name, baseStats);
        this.type = type;
        this.lootable = lootable;


    }

    public List<Item> getLootable() {
        return lootable;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
