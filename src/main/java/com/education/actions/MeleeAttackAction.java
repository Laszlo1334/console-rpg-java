package com.education.actions;

import com.education.core.DamageType;
import com.education.units.Unit;

public class MeleeAttackAction implements BattleAction{
    public MeleeAttackAction() {
    }

    @Override
    public String execute(Unit actor, Unit target) {
        int totalDamage = actor.getTotalDamage();
        int receiveDamage = target.takeDamage(totalDamage, DamageType.PHYSICAL);
        return actor.getName() + " deals " + target.getName() + " " + receiveDamage + " damage." + "\n" +
                target.getName() + " now has " + target.getCurrentHealth() + " health.";

    }

    @Override
    public String getName() {
        return "Melee attack";
    }
}
