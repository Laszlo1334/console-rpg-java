package com.education.items.ConsumableItems;

import com.education.items.ConsumableItems.effects.Effect;
import com.education.items.Item;
import com.education.items.ItemRarity;
import com.education.units.Unit;

import java.util.ArrayList;
import java.util.List;

public abstract class ConsumableItem extends Item implements Usable {
    private final List<Effect> effects;

    public ConsumableItem(String name, int price, ItemRarity rarity) {
        super(name, price, rarity);
        this.effects = new ArrayList<>();
    }


    @Override
    public void use(Unit target){
        this.effects.forEach((effect)-> effect.apply(target));
    }

    public List<Effect> getEffects() {
        return effects;
    }

}
