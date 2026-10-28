package com.education.units;

import com.education.core.StatType;

import java.util.Map;

public class Hero extends Unit{
    private int lvl;
    private int gold;


    public Hero(String name, Map<StatType, Integer> baseStats,  int lvl, int gold) {
        super(name, baseStats);
        this.lvl = lvl;
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }
}
