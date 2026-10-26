package com.education.items.consumables;

import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.effects.buff.DamageBuff;
import com.education.items.ItemRarity;

public class DamagePotion extends ConsumableItem{
    //Main Constructor
    public DamagePotion(String name, int price, ItemRarity rarity) {
        super(name, price, rarity, new SelfTargetingStrategy());
        this.addEffect(new DamageBuff("God's Strength", 3, 10));
    }
    //Copy Constructor
    public DamagePotion(DamagePotion template){
        super(template.getName(), template.getPrice(), template.getRarity(), template.getTargetStrategy());
        this.addEffect(new DamageBuff("God's Strength", 3, 10));
        this.setQuantity(1);
    }

    @Override
    public DamagePotion copy(){
        return new DamagePotion(this);
    }

}
