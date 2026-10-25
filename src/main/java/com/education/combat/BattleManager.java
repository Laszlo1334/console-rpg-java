package com.education.combat;

import com.education.actions.BattleAction;
import com.education.actions.MeleeAttackAction;
import com.education.actions.UseItemAction;
import com.education.items.consumables.ConsumableItem;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.Unit;

import java.util.List;
import java.util.Scanner;

public class BattleManager {
    private final Scanner scanner = new Scanner(System.in);

    public void start1v1Battle (Hero hero, Enemy enemy){

        System.out.println("Battle starts: " + hero.getName() + " vs " + enemy.getName());

        while (hero.isAlive() && enemy.isAlive()){
            playerTurn(hero, enemy);

            if(enemy.isAlive()){
                enemyTurn(hero,enemy);
            }

            hero.updateBuffs();
            enemy.updateBuffs();

        }
    }

    private void playerTurn (Hero hero, Enemy enemy){
        boolean turnCompleted = false;
        while(!turnCompleted){
            System.out.println("Hero's turn!");
            System.out.println(
                    "Choose your action:\n" +
                            "1. Melee attack\n" +
                            "2. Choose item to use\n" +
                            "3. Skip turn");
            int choice = scanner.nextInt();
            if(choice == 1){
                MeleeAttackAction meleeAttackAction = new MeleeAttackAction();
                meleeAttackAction.execute(hero, enemy);
                turnCompleted = true;

            }
            else if(choice == 2){
                ConsumableItem selectedItem = chooseItemFromInventory(hero);
                if(selectedItem != null){
                    Unit target = selectedItem.getTargetStrategy().selectTarget(hero, enemy);

                    BattleAction useItem = new UseItemAction(selectedItem);
                    useItem.execute(hero, target);
                    turnCompleted = true;
                }
            }else if(choice == 3){
                turnCompleted = true;
            }
            else{

                System.out.println("You chose wrong option try again!");
            }
        }
    }

    private void enemyTurn (Hero hero, Enemy enemy){
        System.out.println("Enemy's turn!");
        MeleeAttackAction meleeAttackAction = new MeleeAttackAction();
        meleeAttackAction.execute(enemy, hero);
    }

    private ConsumableItem chooseItemFromInventory (Hero hero){
        System.out.println("Choose your item: ");

        List<ConsumableItem> heroConsumableItems = hero.getInventory().getConsumableItems();
        if(heroConsumableItems.isEmpty()){
            System.out.println("You have no consumable items.");
            return null;
        }
        for(int i = 0; i < heroConsumableItems.size(); i++){
            System.out.println((i+1) + ". " + heroConsumableItems.get(i).getName());
        }
        System.out.println("0. Go back");
        while(true){
            int choice = scanner.nextInt();
            if(choice == 0) return null;
            if(choice <= heroConsumableItems.size() && choice > 0){
                return heroConsumableItems.get(choice - 1);
            }else {
                System.out.println("Invalid choice, try again!");
            }
        }

    }
}
