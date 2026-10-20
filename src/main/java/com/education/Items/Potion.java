package com.education.Items;

public class Potion extends Item{
    private int healAmount;

    public Potion(String name, int price, ItemRarity rarity, boolean usable, int healAmount) {
        super(name, price, rarity, true);
        this.healAmount = healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
