package com.education.items;

import com.education.combat.targeting.EnemyTargetStrategy;
import com.education.combat.targeting.SelfTargetingStrategy;
import com.education.core.DamageType;
import com.education.core.StatType;
import com.education.core.effects.StatusEffectFactory;
import com.education.core.effects.instant.DamageInstant;
import com.education.core.effects.instant.HealInstant;
import com.education.inventory.EquipmentSlot;

public final class ItemFactory {
    private ItemFactory() {
    }

    public static ConsumableItem createHealthPotion(int healAmount){
        ConsumableItem item = new ConsumableItem(
                "Health Potion",
                100,
                ItemRarity.COMMON,
                new SelfTargetingStrategy());
        item.addEffect(new HealInstant(healAmount));
        return item;
    }

    public static ConsumableItem createDamageBuffPotion(int amount, int duration){
        ConsumableItem item = new ConsumableItem(
                "Damage potion",
                150,
                ItemRarity.UNCOMMON,
                new SelfTargetingStrategy()
        );
        item.addEffect(StatusEffectFactory.createStatTypeBuff("Damage Buff", StatType.DAMAGE,amount, duration));
        return item;
    }

    public static ConsumableItem createRocket(int amount){
        ConsumableItem item = new ConsumableItem(
                "Rocket",
                200,
                ItemRarity.UNCOMMON,
                new EnemyTargetStrategy()
        );
        item.addEffect(new DamageInstant(amount, DamageType.PHYSICAL));
        return item;
    }

    public static EquippableItem createArmor (){
        EquippableItem item = new EquippableItem(
                "Chest",
                300,
                ItemRarity.COMMON,
                EquipmentSlot.CHEST
        );
        item.addBonus(StatType.ARMOR, 5);
        return item;
    }

    public static EquippableItem createSword (){
        EquippableItem item = new EquippableItem(
                "Sword",
                300,
                ItemRarity.COMMON,
                EquipmentSlot.RIGHT_HAND
        );
        item.addBonus(StatType.DAMAGE, 5);
        return item;
    }
}
