package com.education;

import com.education.abilities.Ability;
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
        Ability fireBallAbility = new Ability(
                "Fire Ball",
                new EnemyTargetStrategy(),
                3,
                true,
                "Gives 10 magic damage and apply burning effect for 3 turn."
        );

        fireBallAbility.addTargetEffect(new DamageInstant(10, DamageType.MAGICAL));
        fireBallAbility.addResourceCost(ResourceType.MANA, 20);
        StatusEffect burning = new StatusEffect("Burning", 3);
        burning.addTickEffect(new DamageInstant(3, DamageType.MAGICAL));
        fireBallAbility.addTargetEffect(burning);

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

        BattleManager battleManager = new BattleManager(new ConsoleUI());
        battleManager.start1v1Battle(hero, enemy);
    }
}