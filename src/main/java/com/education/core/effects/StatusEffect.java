package com.education.core.effects;

import com.education.core.StatType;
import com.education.units.Unit;

import java.util.*;

public class StatusEffect implements Effect {
    private String name;
    private int duration;
    private final Map<StatType, Integer> modifiers;
    private final List<Effect> tickEffects;

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.modifiers = new HashMap<>();
        this.tickEffects = new ArrayList<>();
    }

    public int getModifier(StatType stat){
        return this.modifiers.getOrDefault(stat, 0);
    }

    protected String onTick(Unit target){
        return "";
    }

    //proceed all ticket effects if it is present and return logged message about what happened
    public final List<String> processTurn(Unit target){
        List<String> turnLogs = new ArrayList<>();
        for (Effect effect : tickEffects) {
            turnLogs.add(effect.apply(target));
        }
        String hookMessage = onTick(target);
        if (hookMessage != null && !hookMessage.isEmpty()) {
            turnLogs.add(hookMessage);
        }
        decrementDuration(1);
        return turnLogs;
    }

    @Override
    public String apply (Unit target){
        target.addStatusEffect(this);
        return this.name + " is applied to " + target.getName() + " for " + duration + " turns.";
    }

    public int decrementDuration(int times){
        return this.duration -= times;
    }

    public boolean isExpired (){
        return (this.duration <= 0);
    }

    public void addTickEffect (Effect effect){
        this.tickEffects.add(effect);
    }

    public void addModifier (StatType type, int amount){
        this.modifiers.put(type, amount);
    }
    public Map<StatType, Integer> getModifiers() {
        return modifiers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        StatusEffect that = (StatusEffect) o;
        return (Objects.equals(this.name, that.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
