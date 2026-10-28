package com.education.core.effects.instant;

import com.education.core.effects.Effect;
import com.education.units.Unit;

public class HealInstant implements Effect {
    private int healAmount;

    public HealInstant(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public String apply(Unit target){
        int receivedHeal = target.heal(this.healAmount);
        return target.getName() + " is healed for " + receivedHeal;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
