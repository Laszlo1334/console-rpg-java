package com.education;

import com.education.combat.BattleManager;
import com.education.items.ItemRarity;
import com.education.items.consumables.DamagePotion;
import com.education.items.consumables.HealthPotion;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.builders.EnemyBuilder;
import com.education.units.builders.HeroBuilder;

public class Main {
    public static void main(String[] args) {
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
                .build();

        HealthPotion healthPotion = new HealthPotion("Health Potion", 10, ItemRarity.COMMON, 20);
        DamagePotion damagePotion = new DamagePotion("God's Strength", 20, ItemRarity.RARE);

        hero.getInventory().addItem(healthPotion);
        hero.getInventory().addItem(damagePotion);

        BattleManager battleManager = new BattleManager();
        battleManager.start1v1Battle(hero, enemy);
    }
}