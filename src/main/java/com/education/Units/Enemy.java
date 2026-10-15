package com.education.Units;

public class Enemy extends Unit{
    private String type;

    public Enemy(String name, int health, int baseDamage, String type) {
        super(name, health, baseDamage);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
