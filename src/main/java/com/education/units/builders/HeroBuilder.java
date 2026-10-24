package com.education.units.builders;

import com.education.items.StatType;
import com.education.units.Hero;

public class HeroBuilder extends UnitBuilder<HeroBuilder>{
    private int lvl;

    public HeroBuilder(String name) {
        super(name);
    }

    public HeroBuilder lvl(int lvl){
        this.lvl = lvl;
        return self();
    }

    @Override
    protected HeroBuilder self() {
        return this;
    }

    @Override
    public Hero build() {
        return new Hero(getName(), getBaseStats(),lvl);

    }
}
