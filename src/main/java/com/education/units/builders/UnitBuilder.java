package com.education.units.builders;

import com.education.items.StatType;
import com.education.units.Unit;

import java.util.EnumMap;
import java.util.Map;

public abstract class UnitBuilder<T> {
    private String name;
    private Map<StatType, Integer> baseStats;

    public UnitBuilder(String name) {
        this.name = name;
        this.baseStats = new EnumMap<>(StatType.class);
        for(StatType type : StatType.values()){
            this.baseStats.put(type, 0);
        }
    }

    protected abstract T self();

    public abstract Unit build();

    public T stat(StatType type, int amount){
        this.baseStats.put(type, amount);
        return self();
    }

    public T maxHealth (int maxHealth){
        this.baseStats.put(StatType.MAX_HEALTH, maxHealth);
        return self();
    }

    public T maxMana (int maxMana){
        this.baseStats.put(StatType.MAX_MANA, maxMana);
        return self();
    }

    public T baseDamage (int damage){
        this.baseStats.put(StatType.DAMAGE, damage);
        return self();
    }

    public T baseArmor (int armor){
        this.baseStats.put(StatType.ARMOR, armor);
        return self();
    }

    protected String getName() {
        return name;
    }

    protected Map<StatType, Integer> getBaseStats() {
        return baseStats;
    }
}
