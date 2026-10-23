package com.education.units;

public class Hero extends Unit{
    private int lvl;
    private int currentMana;


    public Hero(String name, int health, int maxHealth, int baseDamage, int lvl, int currentMana) {
        super(name, maxHealth, baseDamage);
        this.lvl = lvl;
        this.currentMana = currentMana;
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
