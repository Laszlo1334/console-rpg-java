package com.education.Inventory;

import com.education.Items.Weapon;

import java.util.UUID;

public class Equipment {
    private final UUID id;
    private Weapon rightHand = null;

    public Equipment() {
        this.id = UUID.randomUUID();
    }
    public int getTotalBonusDamage(){
        if(rightHand != null){
            return this.rightHand.getBonusDamage();
        }
        return 0;
    }

    public void setRightHand(Weapon rightHand) {
        this.rightHand = rightHand;
    }

    public UUID getId() {
        return id;
    }

    public Weapon getRightHand() {
        return rightHand;
    }
}
