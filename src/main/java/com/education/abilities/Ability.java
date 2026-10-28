package com.education.abilities;

import com.education.combat.targeting.TargetStrategy;
import com.education.core.ResourceType;
import com.education.core.effects.Effect;
import com.education.units.Unit;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ability {
    private final String name;
    private boolean consumeTurn = true;
    private final TargetStrategy targetStrategy;
    private final Map<ResourceType, Integer> resourceCosts = new EnumMap<>(ResourceType.class);
    private final int baseCooldown;
    private int currentCooldown;
    private final String description;
    private final List<Effect> selfEffects;
    private final List<Effect> targetEffects;


    public Ability(String name, TargetStrategy targetStrategy, int baseCooldown, boolean consumeTurn, String description) {
        this.name = name;
        this.targetStrategy = targetStrategy;
        this.baseCooldown = baseCooldown;
        this.consumeTurn = consumeTurn;
        this.currentCooldown = 0;
        this.description = description;
        this.selfEffects = new ArrayList<>();
        this.targetEffects = new ArrayList<>();
    }

    public boolean canCast (Unit caster, Unit target){
        if(currentCooldown != 0){
            return false;
        }
        for (ResourceType type : this.resourceCosts.keySet()) {
            int cost = this.resourceCosts.get(type);
            if (!type.hasEnoughResource(caster, cost)) {
                return false;
            }
        }
        return true;
    }

    public final List<String> execute(Unit caster, Unit target){
        List<String> abilityLogs = new ArrayList<>();
        if(!canCast(caster, target)){
            abilityLogs.add("Cannot cast " + this.getName());
            return abilityLogs;
        }
        for(ResourceType type : this.resourceCosts.keySet()){
            int cost = this.resourceCosts.get(type);
            abilityLogs.add(type.consumeUnitResource(caster, cost));
        }

        this.selfEffects.forEach(effect -> abilityLogs.add(effect.apply(caster)));
        this.targetEffects.forEach(effect -> abilityLogs.add(effect.apply(target)));
        this.currentCooldown = this.baseCooldown;
        String onCastLog = onCast(caster, target);
        if (onCastLog != null && !onCastLog.isEmpty()) abilityLogs.add(onCastLog);
        return abilityLogs;
    }

    protected String onCast(Unit caster, Unit target){
        return "";
    }

    public void addResourceCost(ResourceType resourceType, int amount){
        this.resourceCosts.put(resourceType, amount);
    }

    public void addSelfEffect(Effect effect) {
        this.selfEffects.add(effect);
    }

    public void addTargetEffect(Effect effect) {
        this.targetEffects.add(effect);
    }

    public void decrementCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isConsumeTurn() {
        return consumeTurn;
    }

    public String getDescription() {
        return description;
    }

    public void setConsumeTurn(boolean consumeTurn) {
        this.consumeTurn = consumeTurn;
    }

    public TargetStrategy getTargetStrategy() {
        return targetStrategy;
    }

    public Map<ResourceType, Integer> getResourceCosts() {
        return resourceCosts;
    }


    public int getBaseCooldown() {
        return baseCooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }

    public List<Effect> getSelfEffects() {
        return selfEffects;
    }

    public List<Effect> getTargetEffects() {
        return targetEffects;
    }


}
