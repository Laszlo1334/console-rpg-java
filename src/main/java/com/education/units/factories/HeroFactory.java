package com.education.units.factories;

import com.education.abilities.AbilityFactory;
import com.education.core.StatType;
import com.education.items.ItemFactory;
import com.education.units.Hero;
import com.education.units.builders.HeroBuilder;

public final class HeroFactory {
    private HeroFactory() {
    }

    public static Hero createArthas() {
        return new HeroBuilder("Arthas")
                .addAbility(AbilityFactory.createHeal(20))
                .addEquippedItem(ItemFactory.createSword())
                .addInventoryItem(ItemFactory.createDamageBuffPotion(10, 3))
                .addInventoryItem(ItemFactory.createHealthPotion(20))
                .lvl(1)
                .gold(100)
                .baseArmor(2)
                .baseDamage(10)
                .maxHealth(120)
                .maxMana(50)
                .stat(StatType.CRITICAL_CHANCE, 10)
                .stat(StatType.MANA_REGENERATION, 2)
                .stat(StatType.HEALTH_REGENERATION, 5)
                .stat(StatType.MAGIC_RESISTANCE, 5)
                .build();

    }

    public static Hero createFireMage() {
        return new HeroBuilder("Fire Mage")
                .addAbility(AbilityFactory.createFireBall())
                .addEquippedItem(ItemFactory.createArmor())
                .addInventoryItem(ItemFactory.createHealthPotion(20))
                .lvl(1)
                .gold(100)
                .baseArmor(1)
                .baseDamage(5)
                .maxHealth(100)
                .maxMana(100)
                .stat(StatType.MANA_REGENERATION, 5)
                .stat(StatType.HEALTH_REGENERATION, 2)
                .stat(StatType.MAGIC_RESISTANCE, 10)
                .build();
    }
}
