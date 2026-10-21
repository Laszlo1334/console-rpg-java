package com.education.items.ConsumableItems;

import com.education.items.ItemRarity;
import com.education.units.Unit;

public class HealthPotion extends ConsumableItem {
    private int healAmount;

    public HealthPotion(String name, int price, ItemRarity rarity, int healAmount) {
        super(name, price, rarity);
        this.healAmount = healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void use (Unit target){
        target.heal(healAmount);
        System.out.println(target.getName() + " drinks " + this.getName() + " and heals for " + healAmount + " HP!");
    }
}
