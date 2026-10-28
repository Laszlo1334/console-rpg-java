package com.education.core;

public enum DamageType {
    PHYSICAL(StatType.ARMOR),
    MAGICAL(StatType.MAGIC_RESISTANCE),
    TRUE(null);

    private final StatType resistanceStat;

    DamageType(StatType resistanceStat) {
        this.resistanceStat = resistanceStat;
    }

    public int calculateActualDamage(int rawDamage, int resistance) {
        return switch (this) {
            case PHYSICAL -> Math.max(0, rawDamage - resistance);
            case MAGICAL -> Math.max(0, rawDamage * (100 - resistance) / 100);
            case TRUE -> Math.max(0, rawDamage);
        };
    }

    public StatType getResistanceStat() {
        return resistanceStat;
    }
}
