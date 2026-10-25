package com.education.items.consumables;

import com.education.combat.targeting.TargetStrategy;
import com.education.items.Item;
import com.education.items.ItemRarity;
import com.education.core.effects.Effect;
import com.education.items.Usable;
import com.education.units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ConsumableItem extends Item implements Usable {
    private final List<Effect> effects;
    private final TargetStrategy targetStrategy;

    public ConsumableItem(String name, int price, ItemRarity rarity, TargetStrategy targetStrategy) {
        super(name, price, rarity);
        this.effects = new ArrayList<>();
        this.targetStrategy = targetStrategy;
    }


    @Override
    public void use(Unit target){
        this.effects.forEach((effect)-> effect.apply(target));
    }

    protected void addEffect (Effect effect){
        this.effects.add(effect);
    }

    public TargetStrategy getTargetStrategy() {
        return targetStrategy;
    }

    public List<Effect> getEffects() {
        return Collections.unmodifiableList(this.effects);
    }

}
