package com.education.managers;

import com.education.units.Enemy;
import com.education.units.Hero;

import java.util.Scanner;

public class BattleManager {

    public void startBattle (Hero hero, Enemy enemy){
        Scanner scanner = new Scanner(System.in);
        boolean isFighting = true;
        int healAmount = 20;

        while (isFighting){
            System.out.println("Hero's turn!");
            System.out.println(
                    "Choose your action:\n" +
                    "1. Attack\n" +
                    "2. Heal (+20 HP)");
            int choice = scanner.nextInt();
            if(choice == 1){
                enemy.takeDamage(hero.getTotalDamage());
                System.out.println( hero.getName() + " deals " + hero.getTotalDamage() + " to " + enemy.getName() + ".\n" +
                        enemy.getName() + " has " + enemy.getCurrentHealth() + " hp now.");
                if(!enemy.isAlive()) {
                    System.out.println("Enemy defeated!");
                    isFighting = false;
                    continue;
                }
            }
            else if(choice == 2){
                hero.heal(healAmount);
                System.out.println(hero.getName() + " get healed by " + healAmount + "!\n" +
                         hero.getName() + " has " + hero.getCurrentHealth() + " now.");
            }else{
                System.out.println("You chose wrong option try again!");
                continue;
            }

            System.out.println("Enemy's turn!");
            hero.takeDamage(enemy.getTotalDamage());
            System.out.println( enemy.getName() + " deals " + enemy.getTotalDamage() + " to " + hero.getName() + ".\n" +
                    hero.getName() + " has " + hero.getCurrentHealth() + " hp now.");
            if(!hero.isAlive()) {
                System.out.println("Hero defeated!");
                isFighting = false;
            }

        }
    }
}
