package com.education.combat;

import com.education.actions.BattleAction;
import com.education.actions.MeleeAttackAction;
import com.education.actions.UseItemAction;
import com.education.items.Item;
import com.education.items.consumables.ConsumableItem;
import com.education.ui.ConsoleUI;
import com.education.units.Enemy;
import com.education.units.Hero;
import com.education.units.Unit;

import java.util.List;

public class BattleManager {
    private final ConsoleUI ui;

    public BattleManager(ConsoleUI ui) {
        this.ui = ui;
    }

    public void start1v1Battle (Hero hero, Enemy enemy){

        ui.showMessage("Battle starts: " + hero.getName() + " vs " + enemy.getName());

        while (hero.isAlive() && enemy.isAlive()){
            ui.showMessage(hero.updateStatusEffects());

            playerTurn(hero, enemy);

            ui.showMessage(enemy.updateStatusEffects());

            if(enemy.isAlive()){
                enemyTurn(hero,enemy);
            }
        }
        if(hero.isAlive()){
            ui.showMessage("Victory!!!\n" +
                    "What do you want to loot from enemy?");
            lootEnemy(hero, enemy);

        } else if(enemy.isAlive()){
            ui.showMessage("Defeat!!! Better luck next time.");
        }else{
            ui.showMessage("Draw!!! How does it happened?");
        }
    }

    //Player main function
    private void playerTurn (Hero hero, Enemy enemy){
        boolean turnCompleted = false; //check of right player's choice
        while(!turnCompleted){
            ui.showMessage("Hero's turn!");
            //List of accessible actions
            ui.showMessage(
                    "Choose your action:\n" +
                            "1. Melee attack\n" +
                            "2. Choose item to use\n" +
                            "3. Skip turn");
            int choice = ui.getUserIntInput();
            switch (choice){
                //MeleeAttack choice
                case 1 : {
                    MeleeAttackAction meleeAttack = new MeleeAttackAction();
                    ui.showMessage(meleeAttack.execute(hero, enemy));
                    turnCompleted = true;
                    break;
                }
                //ChooseItemFromInventory choice
                case 2:{
                    ConsumableItem selectedItem = chooseItemFromInventory(hero);
                    //Check who is the item's target
                    if(selectedItem != null) {
                        Unit target = selectedItem.getTargetStrategy().selectTarget(hero, enemy);
                        //Use of item
                        BattleAction useItem = new UseItemAction(selectedItem);
                        ui.showMessage(useItem.execute(hero, target));
                        turnCompleted = true;
                    }
                    break;
                }
                //Skip choice
                case 3: {
                    turnCompleted = true;
                    break;
                }
                //Wrong choice
                default: {
                    ui.showMessage("You chose wrong option try again!");
                    break;
                }
            }
        }
    }

    //Enemy hit player by its melee attack
    private void enemyTurn (Hero hero, Enemy enemy){
        ui.showMessage("Enemy's turn!");
        MeleeAttackAction meleeAttackAction = new MeleeAttackAction();
        ui.showMessage(meleeAttackAction.execute(enemy, hero));
    }

    private ConsumableItem chooseItemFromInventory (Hero hero){
        ui.showMessage("Choose your item: ");

        List<ConsumableItem> heroConsumableItems = hero.getInventory().getConsumableItems();
        //Check if player has consumable items
        if(heroConsumableItems.isEmpty()){
            ui.showMessage("You have no consumable items.");
            return null;
        }
        //Printing list of Consumable items
        for(int i = 0; i < heroConsumableItems.size(); i++){
            ui.showMessage((i+1) + ". " + heroConsumableItems.get(i).getName() + " (x" + heroConsumableItems.get(i).getQuantity() + ")");
        }
        ui.showMessage("0. Go back");
        //Get player's choice and use the item he had chosen
        while(true){
            int choice = ui.getUserIntInput();
            if(choice == 0) return null;
            if(choice <= heroConsumableItems.size() && choice > 0){
                return heroConsumableItems.get(choice - 1);
            }else {
                ui.showMessage("Invalid choice, try again!");
            }
        }

    }

    private void lootEnemy (Hero hero, Enemy enemy){
        while(true){
            List<Item> enemyList = enemy.getLootable();
            //Check if enemy has loot to take
            if(enemyList.isEmpty()){
                ui.showMessage("The enemy's pockets are empty.");
                break;
            }
            //Printing enemy's lootable list
            ui.showMessage("1. Take all items");
            for(int i = 0; i < enemy.getLootable().size(); i++){
                Item item = enemyList.get(i);
                if(item instanceof ConsumableItem consumableItem){
                    ui.showMessage((i + 2) + ". " + consumableItem.getName() + " (x" + consumableItem.getQuantity() + ")");
                }
                else {
                    ui.showMessage((i + 2) + ". " + item.getName());
                }
            }
            ui.showMessage("0. Don't take anything");

            //Taking player's choice
            int choice = ui.getUserIntInput();

            if(choice == 0) break;  //if player choose not to take any items
            if(choice == 1){   //if player choose all items
                for(Item item : enemyList){
                    hero.getInventory().addItem(item);
                }
                enemyList.clear();
                ui.showMessage("Player looted all items.");
                return;
            }
            if(choice <= enemyList.size() + 1 && choice > 1){   //If player choose 1 item
                Item chosenItem = enemyList.get(choice - 2);
                hero.getInventory().addItem(chosenItem);
                enemyList.remove(chosenItem);
                ui.showMessage("Player looted " + chosenItem.getName());
            }
            else {   //Invalid choice
                ui.showMessage("Invalid choice, try again!");
            }
        }
    }
}
