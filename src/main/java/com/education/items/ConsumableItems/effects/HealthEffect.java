package com.education.items.ConsumableItems.effects;

import com.education.units.Unit;

public abstract class HealthEffect extends Effect{
    private int healAmount;

    public HealthEffect( int healAmount) {
        super("Healing");
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
