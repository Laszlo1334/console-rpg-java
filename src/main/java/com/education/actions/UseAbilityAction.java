package com.education.actions;

import com.education.abilities.Ability;
import com.education.units.Unit;

import java.util.List;

public record UseAbilityAction(Ability ability) implements BattleAction {

    @Override
    public String execute(Unit actor, Unit target) {
        if (!this.ability.canCast(actor, target)) {
            return "Cannot use " + this.ability.getName() + ".";
        }
        List<String> abilityUsageLog = this.ability.execute(actor, target);
        return String.join("\n", abilityUsageLog);

    }

    @Override
    public String getName() {
        return "Used " + this.ability.getName();
    }
}
