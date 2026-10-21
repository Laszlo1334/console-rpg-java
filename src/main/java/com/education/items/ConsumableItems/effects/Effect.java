package com.education.items.ConsumableItems.effects;

import com.education.units.Unit;

import java.util.UUID;

public abstract class Effect {
    private final UUID id;
    private String name;

    public Effect( String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public abstract void apply(Unit target);

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
