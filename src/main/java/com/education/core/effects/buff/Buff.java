package com.education.core.effects.buff;

import com.education.core.StatType;
import com.education.core.effects.Effect;
import com.education.units.Unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Buff implements Effect {
    private String name;
    private int duration;
    protected final Map<StatType, Integer> modifiers;

    public Buff(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.modifiers = new HashMap<>();
    }

    public int getModifier(StatType stat){
        return this.modifiers.getOrDefault(stat, 0);
    }


    @Override
    public void apply (Unit target){
        target.addBuff(this);
    }

    public int decrementDuration(int times){
        return this.duration -= times;
    }

    public boolean isExpired (){
        return (this.duration <= 0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Buff that = (Buff) o;
        return (Objects.equals(this.name, that.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
}
