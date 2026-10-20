package com.education.Items;

public class Weapon extends Item{
    private int bonusDamage;

    public Weapon(String name, int price, ItemRarity rarity, int bonusDamage) {
        super(name, price, rarity, false);
        this.bonusDamage = bonusDamage;
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }
}
