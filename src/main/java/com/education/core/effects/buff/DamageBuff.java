package com.education.core.effects.buff;

import com.education.core.StatType;

public class DamageBuff extends Buff {
    public DamageBuff(String name, int duration, int damage) {
        super(name, duration);
        super.modifiers.put(StatType.DAMAGE, damage);
    }

}
