package com.education.items;

import com.education.combat.targeting.TargetStrategy;
import com.education.core.effects.Effect;
import com.education.units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsumableItem extends Item implements Usable {
    private final List<Effect> effects;
    private final TargetStrategy targetStrategy;
    private int quantity;

    public ConsumableItem(String name, int price, ItemRarity rarity, TargetStrategy targetStrategy) {
        super(name, price, rarity);
        this.effects = new ArrayList<>();
        this.targetStrategy = targetStrategy;
        this.quantity = 1;
    }

    @Override
    public void use(Unit target){
        this.effects.forEach((effect)-> effect.apply(target));
    }

    public void addEffect (Effect effect){
        this.effects.add(effect);
    }

    public TargetStrategy getTargetStrategy() {
        return targetStrategy;
    }

    public List<Effect> getEffects() {
        return Collections.unmodifiableList(this.effects);
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }
    public void reduceQuantity (int amount){
        this.quantity -= amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isItemsLeft(){
        return quantity > 0;
    }
}
