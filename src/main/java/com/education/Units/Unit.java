package com.education.Units;

import java.util.Objects;
import java.util.UUID;

public abstract class Unit {
    private final UUID id;
    private String name;
    private int health;
    private int baseDamage;

    public Unit(String name, int health, int baseDamage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.health = health;
        this.baseDamage = baseDamage;
    }
    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit that = (Unit) o;
        return (Objects.equals(this.id, that.getId()));

    }

    @Override
    public int hashCode (){
        return Objects.hash(this.id);
    }


    public int takeDamage(int damage){
        return this.health -= damage;
    }
    public int heal(int heal){
        return this.health += heal;
    }
    public boolean isAlive(){
        return health > 0;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

}
