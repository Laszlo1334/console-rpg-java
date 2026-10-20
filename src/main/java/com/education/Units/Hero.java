package com.education.Units;

public class Hero extends Unit{
    private int lvl;
    private int mana;


    public Hero(String name, int health, int baseDamage, int mana, int lvl) {
        super(name, health, baseDamage);
        this.mana = mana;
        this.lvl = lvl;
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
