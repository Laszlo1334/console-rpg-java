package com.education.items.consumables;

import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.effects.instant.HealInstant;
import com.education.items.ItemRarity;

public class HealthPotion extends ConsumableItem {

    public HealthPotion(String name, int price, ItemRarity rarity, int healAmount) {
        super(name, price, rarity, new SelfTargetingStrategy());
        this.addEffect(new HealInstant(healAmount));
    }

}
