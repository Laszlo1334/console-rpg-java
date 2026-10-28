package com.education.core.effects.instant;

import com.education.core.DamageType;
import com.education.core.effects.Effect;
import com.education.units.Unit;

public class DamageInstant implements Effect {
    private int damageAmount;
    private DamageType damageType;

    public DamageInstant(int damageAmount, DamageType damageType) {
        this.damageAmount = damageAmount;
        this.damageType = damageType;
    }

    @Override
    public String apply(Unit target) {
        int receivedDamage = target.takeDamage(this.damageAmount, this.damageType);
        return target.getName() + " takes " + receivedDamage + " " + this.damageType + " damage.";
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

}
