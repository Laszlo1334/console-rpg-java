package com.education.units;

import com.education.core.StatType;

import java.util.Map;

public class Hero extends Unit{
    private int lvl;
    private int currentMana;


    public Hero(String name, Map<StatType, Integer> baseStats,  int lvl) {
        super(name, baseStats);
        this.lvl = lvl;
        this.currentMana = baseStats.get(StatType.MAX_MANA);
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getLvl() {
        return lvl;
    }

    public int getCurrentMana() {
        return currentMana;
    }
}
