package com.education.units;

import com.education.core.StatType;

import java.util.Map;

public class Enemy extends Unit{
    private String type;

    public Enemy(String name, String type, Map<StatType, Integer> baseStats) {
        super(name, baseStats);
        this.type = type;

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
