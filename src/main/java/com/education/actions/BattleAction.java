package com.education.actions;

import com.education.units.Unit;

public interface BattleAction {
    String execute (Unit actor, Unit target);
    String getName();
}
