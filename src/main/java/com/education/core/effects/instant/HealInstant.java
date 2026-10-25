package com.education.core.effects.instant;

import com.education.core.effects.Effect;
import com.education.units.Unit;

public class HealInstant implements Effect {
    private int healAmount;

    public HealInstant(int healAmount) {
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
