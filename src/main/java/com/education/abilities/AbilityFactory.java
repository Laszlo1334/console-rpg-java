package com.education.abilities;

import com.education.combat.targeting.EnemyTargetStrategy;
import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.DamageType;
import com.education.core.ResourceType;
import com.education.core.effects.StatusEffectFactory;
import com.education.core.effects.instant.DamageInstant;
import com.education.core.effects.instant.HealInstant;

public final class AbilityFactory {
    private AbilityFactory() {
    }

    public static Ability createFireBall(){
        return new AbilityBuilder("Fire Ball", new EnemyTargetStrategy())
                .addResourceCost(ResourceType.MANA, 20)
                .baseCooldown(3)
                .description("Deals 10 magical damage and applies a burning effect for 3 turns")
                .addTargetEffect(StatusEffectFactory.createBurn(3, 3))
                .addTargetEffect(new DamageInstant(10, DamageType.MAGICAL))
                .build();
    }

    public static Ability createHeal(int amount){
        return new AbilityBuilder("Heal", new SelfTargetingStrategy())
                .addResourceCost(ResourceType.MANA, 15)
                .addSelfEffect(new HealInstant(amount))
                .baseCooldown(2)
                .description("Heals the caster for " + amount + " HP.")
                .build();
    }
}
