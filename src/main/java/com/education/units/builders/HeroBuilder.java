package com.education.units.builders;

import com.education.units.Hero;

public class HeroBuilder extends UnitBuilder<HeroBuilder>{
    private int lvl = 1;
    private int gold = 0;

    public HeroBuilder(String name) {
        super(name);
    }

    public HeroBuilder lvl(int lvl){
        this.lvl = lvl;
        return self();
    }

    public HeroBuilder gold(int gold){
        this.gold = gold;
        return self();
    }

    @Override
    protected HeroBuilder self() {
        return this;
    }

    @Override
    public Hero build() {
        return new Hero(getName(), getBaseStats(),lvl, gold);

    }
}
