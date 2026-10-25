package com.education.actions;

import com.education.units.Unit;

public interface BattleAction {
    void execute (Unit actor, Unit target);
    String getName();
}
