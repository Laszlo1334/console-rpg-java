package com.education;

import com.education.abilities.Ability;
import com.education.abilities.AbilityFactory;
import com.education.combat.BattleManager;
import com.education.combat.targeting.EnemyTargetStrategy;
import com.education.combat.targeting.TargetStrategy;
import com.education.core.DamageType;
import com.education.core.ResourceType;
import com.education.core.effects.StatusEffect;
import com.education.core.effects.instant.DamageInstant;
import com.education.items.ItemRarity;
import com.education.items.consumables.DamagePotion;
import com.education.items.consumables.HealthPotion;
import com.education.ui.ConsoleUI;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.builders.EnemyBuilder;
import com.education.units.builders.HeroBuilder;

public class Main {
    public static void main(String[] args) {

        HealthPotion healthPotion = new HealthPotion("Health Potion", 10, ItemRarity.COMMON, 20);
        DamagePotion damagePotion = new DamagePotion("God's Strength", 20, ItemRarity.RARE);
        Ability fireBallAbility = AbilityFactory.createFireBall();
        Ability healAbility = AbilityFactory.createHeal(10);

        Hero hero = new HeroBuilder("Hero")
                .maxHealth(100)
                .baseArmor(1)
                .lvl(1)
                .baseDamage(5)
                .maxMana(100)
                .build();
        Enemy enemy = new EnemyBuilder("Enemy", "Goblin")
                .maxHealth(20)
                .baseArmor(0)
                .baseDamage(5)
                .addLootableItem(healthPotion.copy())
                .addLootableItem(damagePotion.copy())
                .build();


        hero.getInventory().addItem(healthPotion.copy());
        hero.getInventory().addItem(damagePotion.copy());
        hero.addAbility(fireBallAbility);
        hero.addAbility(healAbility);

        BattleManager battleManager = new BattleManager(new ConsoleUI());
        battleManager.start1v1Battle(hero, enemy);
    }
}