package com.education;

import com.education.combat.BattleManager;
import com.education.ui.ConsoleUI;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.factories.EnemyFactory;
import com.education.units.factories.HeroFactory;

public class Main {
    public static void main(String[] args) {

        Hero hero = HeroFactory.createArthas();
        Enemy enemy = EnemyFactory.createCultistWarlock();

        BattleManager battleManager = new BattleManager(new ConsoleUI());
        battleManager.start1v1Battle(hero, enemy);
    }
}
