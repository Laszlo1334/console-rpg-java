package com.education.items.consumables;

import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.effects.instant.HealInstant;
import com.education.items.ItemRarity;

public class HealthPotion extends ConsumableItem {
    private final int healAmount;

    //Main Constructor
    public HealthPotion(String name, int price, ItemRarity rarity, int healAmount) {
        super(name, price, rarity, new SelfTargetingStrategy());
        this.healAmount = healAmount;
        this.addEffect(new HealInstant(healAmount));
    }

    //The Copy Constructor
    public HealthPotion(HealthPotion template){
        super(template.getName(), template.getPrice(), template.getRarity(), template.getTargetStrategy());
        this.healAmount = template.healAmount;
        this.addEffect(new HealInstant(this.healAmount));
        this.setQuantity(1);
    }

    @Override
    public HealthPotion copy(){
        return new HealthPotion(this);
    }

    public int getHealAmount() {
        return healAmount;
    }
}
