package com.education.units.factories;

import com.education.abilities.AbilityFactory;
import com.education.core.StatType;
import com.education.items.ItemFactory;
import com.education.units.Enemy;
import com.education.units.builders.EnemyBuilder;

public final class EnemyFactory {

    private EnemyFactory() {
    }

    public static Enemy createGoblinRaider() {
        return new EnemyBuilder("Goblin Raider", "Goblin")
                .addEquippedItem(ItemFactory.createSword())
                .addLootableItem(ItemFactory.createHealthPotion(20))
                .addLootableItem(ItemFactory.createSword())
                .baseArmor(1)
                .baseDamage(8)
                .maxHealth(80)
                .maxMana(20)
                .stat(StatType.CRITICAL_CHANCE, 15)
                .stat(StatType.HEALTH_REGENERATION, 2)
                .stat(StatType.MAGIC_RESISTANCE, 2)
                .build();
    }

    public static Enemy createCultistWarlock() {
        return new EnemyBuilder("Cultist Warlock", "Undead")
                .addAbility(AbilityFactory.createFireBall())
                .addEquippedItem(ItemFactory.createArmor())
                .addLootableItem(ItemFactory.createDamageBuffPotion(10, 3))
                .addLootableItem(ItemFactory.createRocket(25))
                .baseArmor(2)
                .baseDamage(6)
                .maxHealth(95)
                .maxMana(80)
                .stat(StatType.MANA_REGENERATION, 5)
                .stat(StatType.HEALTH_REGENERATION, 2)
                .stat(StatType.MAGIC_RESISTANCE, 8)
                .build();
    }
}