package com.education.units;

public class Hero extends Unit{
    private int lvl;
    private int mana;


    public Hero(String name, int health, int maxHealth, int baseDamage, int lvl, int mana) {
        super(name, maxHealth, baseDamage);
        this.lvl = lvl;
        this.mana = mana;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLvl() {
        return lvl;
    }

    public int getMana() {
        return mana;
    }
}
