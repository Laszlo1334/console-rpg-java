package com.education;

import com.education.Units.Enemy;
import com.education.Units.Hero;

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
                enemy.takeDamage(hero.getBaseDamage());
                System.out.println( hero.getName() + " deals " + hero.getBaseDamage() + " to " + enemy.getName() + ".\n" +
                        enemy.getName() + " has " + enemy.getHealth() + " hp now.\n");
                if(!enemy.isAlive()) {
                    System.out.println("Enemy defeated!");
                    isFighting = false;
                    continue;
                }
            }
            else if(choice == 2){
                hero.heal(healAmount);
                System.out.println(hero.getName() + " get healed by " + healAmount + "!\n" +
                         hero.getName() + " has " + hero.getHealth() + " now.");
            }else{
                System.out.println("You chose wrong option try again!");
                continue;
            }

            System.out.println("Enemy's turn!");
            hero.takeDamage(enemy.getBaseDamage());
            System.out.println( enemy.getName() + " deals " + enemy.getBaseDamage() + " to " + hero.getName() + ".\n" +
                    hero.getName() + " has " + hero.getHealth() + " hp now.\n");
            if(!hero.isAlive()) {
                System.out.println("Hero defeated!");
                isFighting = false;
            }

        }
    }
}
