package com.education.units.builders;

import com.education.items.Item;
import com.education.units.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyBuilder extends UnitBuilder<EnemyBuilder>{
    private String type;
    private final List<Item> lootable = new ArrayList<>();

    public EnemyBuilder(String name, String type) {
        super(name);
        this.type = type;
    }

    public EnemyBuilder type (String type){
        this.type = type;
        return self();
    }

    public EnemyBuilder addLootableItem (Item item){
        this.lootable.add(item);
        return self();
    }

    @Override
    protected EnemyBuilder self() {
        return this;
    }

    @Override
    public Enemy build() {
        return new Enemy(getName(), type,  getBaseStats(), lootable);
    }
}
