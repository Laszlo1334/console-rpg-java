package com.education.core.effects;

import com.education.core.DamageType;
import com.education.core.StatType;
import com.education.core.effects.instant.DamageInstant;
import com.education.core.effects.instant.HealInstant;

public final class StatusEffectFactory {

    private StatusEffectFactory() {
    }

    public static StatusEffect createDamagePerTurn(String name, int damagePerTick,int duration, DamageType type){
        StatusEffect burning = new StatusEffect(name, duration);
        burning.addTickEffect(new DamageInstant(damagePerTick, type));
        return burning;
    }

    public static StatusEffect createStatTypeBuff(String name ,StatType type, int amount, int duration){
        StatusEffect statTypeBuff = new StatusEffect(name, duration);
        statTypeBuff.addModifier(type, amount);
        return statTypeBuff;
    }

    public static StatusEffect createRegeneration(int amount, int duration){
        StatusEffect instantHeal = new StatusEffect("Regeneration", duration);
        instantHeal.addTickEffect(new HealInstant(amount));
        return instantHeal;
    }

    public static StatusEffect createBurn(int damage, int duration){
        return createDamagePerTurn("Burning", damage, duration, DamageType.MAGICAL);
    }


}
