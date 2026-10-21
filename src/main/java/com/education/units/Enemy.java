package com.education.units;

public class Enemy extends Unit{
    private String type;

    public Enemy(String name, int health, int maxHealth, int baseDamage, String type) {
        super(name, maxHealth, baseDamage);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
