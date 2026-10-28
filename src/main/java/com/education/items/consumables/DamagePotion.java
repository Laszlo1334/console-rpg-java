package com.education.items.consumables;

import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.StatType;
import com.education.core.effects.StatusEffect;
import com.education.items.ItemRarity;

public class DamagePotion extends ConsumableItem{
    //Main Constructor
    public DamagePotion(String name, int price, ItemRarity rarity) {
        super(name, price, rarity, new SelfTargetingStrategy());
        StatusEffect effect = new StatusEffect("Damage Boost", 3);
        effect.addModifier(StatType.DAMAGE, 10);
        this.addEffect(effect);
    }
    //Copy Constructor
    public DamagePotion(DamagePotion template){
        super(template.getName(), template.getPrice(), template.getRarity(), template.getTargetStrategy());
        StatusEffect effect = new StatusEffect("Damage Boost", 3);
        effect.addModifier(StatType.DAMAGE, 10);
        this.addEffect(effect);
        this.setQuantity(1);
    }

    @Override
    public DamagePotion copy(){
        return new DamagePotion(this);
    }

}
