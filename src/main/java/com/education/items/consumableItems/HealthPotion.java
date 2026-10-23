package com.education.items.consumableItems;

import com.education.items.ItemRarity;
import com.education.items.consumableItems.effects.instant.HealEffect;

public class HealthPotion extends ConsumableItem {

    public HealthPotion(String name, int price, ItemRarity rarity, int healAmount) {
        super(name, price, rarity);
        this.addEffect(new HealEffect(healAmount));
    }

}
