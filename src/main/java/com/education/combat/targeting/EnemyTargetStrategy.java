package com.education.combat.targeting;

import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.Unit;

public class EnemyTargetStrategy implements TargetStrategy{
    @Override
    public Unit selectTarget(Hero hero, Enemy enemy){
        return enemy;
    }
}
