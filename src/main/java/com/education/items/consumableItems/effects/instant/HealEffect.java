package com.education.items.consumableItems.effects.instant;

import com.education.items.consumableItems.effects.Effect;
import com.education.units.Unit;

public class HealEffect implements Effect {
    private int healAmount;

    public HealEffect(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void apply(Unit target){
        target.heal(this.healAmount);
        System.out.println(target.getName() + " is healed for " + healAmount);
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
