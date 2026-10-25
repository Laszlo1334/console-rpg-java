package com.education.combat.targeting;

import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.Unit;

public interface TargetStrategy {
    Unit selectTarget(Hero actor, Enemy enemy);
}
