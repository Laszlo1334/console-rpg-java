package com.education.items.consumableItems.effects.buff;

import com.education.items.StatType;

public class DamageBuff extends Buff {
    public DamageBuff(String name, int duration, int damage) {
        super(name, duration);
        super.modifiers.put(StatType.DAMAGE, damage);
    }

}
