package com.education.actions;

import com.education.items.consumables.ConsumableItem;
import com.education.units.Unit;

public class UseItemAction implements BattleAction{
    private final ConsumableItem item;

    public UseItemAction(ConsumableItem item) {
        this.item = item;
    }

    @Override
    public void execute(Unit actor, Unit target) {
        System.out.println(actor.getName() + " uses " + item.getName() + " on " + target.getName() + "!");
        item.use(target);
        actor.getInventory().removeItem(item);
    }

    @Override
    public String getName() {
        return "Using consumable item.";
    }

}
