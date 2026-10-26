package com.education.actions;

import com.education.items.consumables.ConsumableItem;
import com.education.units.Unit;

public class UseItemAction implements BattleAction{
    private final ConsumableItem item;

    public UseItemAction(ConsumableItem item) {
        this.item = item;
    }

    @Override
    public String execute(Unit actor, Unit target) {
        item.use(target);
        actor.getInventory().removeItem(item);
        return actor.getName() + " uses " + item.getName() + " on " + target.getName() + "!";
    }

    @Override
    public String getName() {
        return "Using consumable item.";
    }

}
