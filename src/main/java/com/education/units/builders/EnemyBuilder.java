package com.education.units.builders;

import com.education.units.Enemy;
import com.education.units.Unit;

public class EnemyBuilder extends UnitBuilder<EnemyBuilder>{
    private String type;

    public EnemyBuilder(String name, String type) {
        super(name);
        this.type = type;
    }

    public EnemyBuilder type (String type){
        this.type = type;
        return self();
    }


    @Override
    protected EnemyBuilder self() {
        return this;
    }

    @Override
    public Enemy build() {
        return new Enemy(getName(), type,  getBaseStats());
    }
}
