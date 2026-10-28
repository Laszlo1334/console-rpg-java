package com.education.core;

import com.education.units.Unit;

public enum ResourceType {
    HEALTH(StatType.MAX_HEALTH),
    MANA(StatType.MAX_MANA);


    private final StatType associatedStatType;

    ResourceType(StatType associatedStatType) {
        this.associatedStatType = associatedStatType;
    }

    public int getCurrentUnitResource(Unit unit) {
        return switch (this) {
            case HEALTH -> unit.getCurrentHealth();
            case MANA -> unit.getCurrentMana();
        };
    }

    public boolean hasEnoughResource(Unit caster, int amount) {
         return switch (this) {
            case HEALTH -> caster.isEnoughHealth(amount);
            case MANA -> caster.isEnoughMana(amount);
        };
    }

    public String consumeUnitResource(Unit caster, int amount) {
        if(hasEnoughResource(caster, amount)) {
            return switch (this) {
                case HEALTH -> caster.takeDamage(amount, DamageType.TRUE) + " health spent";
                case MANA -> caster.spendMana(amount) + " mana spent";
            };
        } else {
            return "Not enough " + this.name().toLowerCase();
        }
    }




    public StatType getAssociatedStatType() {
        return associatedStatType;
    }
}
