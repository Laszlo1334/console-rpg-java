package com.education.actions;

import com.education.units.Unit;

public class MeleeAttackAction implements BattleAction{
    public MeleeAttackAction() {
    }

    @Override
    public String execute(Unit actor, Unit target) {
        int totalDamage = actor.getTotalDamage();
        target.takeDamage(totalDamage);
        return actor.getName() + " deals " + target.getName() + " " + totalDamage + " damage." + "\n" +
                target.getName() + " now has " + target.getCurrentHealth() + " health.";

    }

    @Override
    public String getName() {
        return "Melee attack";
    }
}
