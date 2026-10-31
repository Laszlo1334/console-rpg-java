package com.education.units;

import com.education.core.DamageType;
import com.education.units.builders.HeroBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void takeDamage_PhysicalDamageWithArmor_ReducesDamage() {
        // 1. ARRANGE: Create a test dummy with exactly 100 HP and 5 Armor.
        Hero target = new HeroBuilder("Test Dummy")
                .maxHealth(100)
                .baseArmor(5)
                .build();

        // 2. ACT: Hit the dummy for 20 Physical Damage.
        target.takeDamage(20, DamageType.PHYSICAL);

        // 3. ASSERT: Check if the health was reduced correctly.
        int expectedHealth = 85;

        assertEquals(expectedHealth, target.getCurrentHealth(), "Armor should reduce physical damage.");
    }
}