package com.education.combat;

import com.education.abilities.Ability;
import com.education.actions.BattleAction;
import com.education.actions.MeleeAttackAction;
import com.education.actions.UseAbilityAction;
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
            ui.showMessage(hero.onTurnStart());

            playerTurn(hero, enemy);

            ui.showMessage(enemy.onTurnStart());

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
                            "3. Use ability\n" +
                            "4. Skip turn");
            int choice = ui.getValidIntInput(1, 4);
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
                //Use action Choice
                case 3: {
                    Ability selectedAbility = chooseAbility(hero);
                    if(selectedAbility != null){
                        if(!selectedAbility.canCast(hero, enemy)){
                            ui.showMessage("You can't execute chosen ability.");
                        }else {
                            //Select abilities target
                            Unit target = selectedAbility.getTargetStrategy().selectTarget(hero, enemy);
                            BattleAction useAbilityAction = new UseAbilityAction(selectedAbility);
                            ui.showMessage(useAbilityAction.execute(hero, target));
                            turnCompleted = selectedAbility.isConsumeTurn();
                        }
                    }

                    break;
                }
                //Skip choice
                case 4: {
                    turnCompleted = true;
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
        List<ConsumableItem> heroConsumableItems = hero.getInventory().getConsumableItems();
        return ui.selectFromList(
                "Choose your item:",
                heroConsumableItems,
                (item -> item.getName() + "(x" + item.getQuantity() + ")"));

    }

    private Ability chooseAbility (Hero hero){
        List<Ability> heroAbilities = hero.getAbilities();
        return ui.selectFromList(
                "Choose your ability:",
                heroAbilities,
                ability -> ability.getName() + " isReady: " + (ability.isReady() ? "Yes": "No"));

    }

    private void lootEnemy (Hero hero, Enemy enemy){
        while(true){
            List<Item> enemyLootableList = enemy.getLootable();
            //Check if enemy has loot to take
            if(enemyLootableList.isEmpty()){
                ui.showMessage("The enemy's pockets are empty.");
                break;
            }
            //Printing enemy's lootable list
            ui.showMessage("1. Take all items");
            for(int i = 0; i < enemy.getLootable().size(); i++){
                Item item = enemyLootableList.get(i);
                if(item instanceof ConsumableItem consumableItem){
                    ui.showMessage((i + 2) + ". " + consumableItem.getName() + " (x" + consumableItem.getQuantity() + ")");
                }
                else {
                    ui.showMessage((i + 2) + ". " + item.getName());
                }
            }
            ui.showMessage("0. Don't take anything");

            //Taking player's choice
            int choice = ui.getValidIntInput(0, enemyLootableList.size() + 1);

            if(choice == 0) break;  //if player choose not to take any items
            if(choice == 1){   //if player choose all items
                for(Item item : enemyLootableList){
                    hero.getInventory().addItem(item);
                }
                enemyLootableList.clear();
                ui.showMessage("Player looted all items.");
                return;
            }
            if(choice <= enemyLootableList.size() + 1 && choice > 1){   //If player choose 1 item
                Item chosenItem = enemyLootableList.get(choice - 2);
                hero.getInventory().addItem(chosenItem);
                enemyLootableList.remove(chosenItem);
                ui.showMessage("Player looted " + chosenItem.getName());
            }

        }
    }
}
