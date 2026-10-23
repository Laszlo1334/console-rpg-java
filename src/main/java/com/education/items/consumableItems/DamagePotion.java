package com.education.items.consumableItems;

import com.education.items.ItemRarity;
import com.education.items.consumableItems.effects.buff.DamageBuff;

public class DamagePotion extends ConsumableItem{
    public DamagePotion(String name, int price, ItemRarity rarity) {
        super(name, price, rarity);
        this.addEffect(new DamageBuff("God's Strength", 3, 10));
    }

}
