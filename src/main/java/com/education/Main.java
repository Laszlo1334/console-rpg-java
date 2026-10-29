package com.education;

import com.education.abilities.Ability;
import com.education.abilities.AbilityFactory;
import com.education.combat.BattleManager;
import com.education.items.ItemFactory;
import com.education.ui.ConsoleUI;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.builders.EnemyBuilder;
import com.education.units.builders.HeroBuilder;

public class Main {
    public static void main(String[] args) {

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
                .addLootableItem(ItemFactory.createHealthPotion(20))
                .addLootableItem(ItemFactory.createRocket(20))
                .build();


        hero.getInventory().addItem(ItemFactory.createHealthPotion(20));
        hero.getInventory().addItem(ItemFactory.createRocket(20));
        hero.getInventory().addItem(ItemFactory.createDamageBuffPotion(10, 3));
        hero.addAbility(fireBallAbility);
        hero.addAbility(healAbility);
        hero.equip(ItemFactory.createSword());
        hero.equip(ItemFactory.createArmor());

        BattleManager battleManager = new BattleManager(new ConsoleUI());
        battleManager.start1v1Battle(hero, enemy);
    }
}