package com.education.abilities;

import com.education.combat.targeting.TargetStrategy;
import com.education.core.ResourceType;
import com.education.core.effects.Effect;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AbilityBuilder {
    //Mandatory fields
    private final String name;
    private final TargetStrategy targetStrategy;
    //Optional fields
    private int baseCooldown = 3;
    private boolean consumeTurn = true;
    private String description = "No description available.";
    private final Map<ResourceType, Integer> resourceCosts = new EnumMap<>(ResourceType.class);
    private final List<Effect> selfEffects = new ArrayList<>();
    private final List<Effect> targetEffects = new ArrayList<>();

    public AbilityBuilder(String name, TargetStrategy targetStrategy ) {
        this.name = name;
        this.targetStrategy = targetStrategy;
    }

    public AbilityBuilder baseCooldown(int baseCooldown){
        this.baseCooldown = baseCooldown;
        return self();
    }

    public AbilityBuilder consumeTurns(boolean consumeTurn){
        this.consumeTurn = consumeTurn;
        return self();
    }

    public AbilityBuilder description(String description){
        this.description = description;
        return self();
    }

    public AbilityBuilder addResourceCost(ResourceType type, int amount){
        this.resourceCosts.put(type, amount);
        return self();
    }

    public AbilityBuilder addSelfEffect(Effect effect){
        this.selfEffects.add(effect);
        return self();
    }

    public AbilityBuilder addTargetEffect(Effect effect){
        this.targetEffects.add(effect) ;
        return self();
    }

    private AbilityBuilder self(){
        return this;
    }

    public Ability build(){
        Ability ability = new Ability( this.name, this.targetStrategy,  this.baseCooldown, this.consumeTurn, this.description);
        this.resourceCosts.forEach(ability :: addResourceCost);
        this.selfEffects.forEach(ability::addSelfEffect);
        this.targetEffects.forEach(ability::addTargetEffect);
        return ability;
    }
}
