package com.education.units.builders;

import com.education.abilities.Ability;
import com.education.core.StatType;
import com.education.items.EquippableItem;
import com.education.items.Item;
import com.education.units.Unit;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class UnitBuilder<T> {
    private String name;
    private Map<StatType, Integer> baseStats;
    private final List<Ability> abilities = new ArrayList<>();
    private final List<Item> inventory = new ArrayList<>();
    private final List<EquippableItem> equippedItems = new ArrayList<>();

    public UnitBuilder(String name) {
        this.name = name;
        this.baseStats = new EnumMap<>(StatType.class);
        for(StatType type : StatType.values()){
            this.baseStats.put(type, 0);
        }
    }

    protected abstract T self();

    public abstract Unit build();

    public T stat(StatType type, int amount){
        this.baseStats.put(type, amount);
        return self();
    }

    public T addInventoryItem(Item item) {
        this.inventory.add(item);
        return self();
    }

    public T addEquippedItem(EquippableItem item) {
        this.equippedItems.add(item);
        return self();
    }

    public T addAbility(Ability ability) {
        this.abilities.add(ability);
        return self();
    }

    public T maxHealth (int maxHealth){
        this.baseStats.put(StatType.MAX_HEALTH, maxHealth);
        return self();
    }

    public T maxMana (int maxMana){
        this.baseStats.put(StatType.MAX_MANA, maxMana);
        return self();
    }

    public T baseDamage (int damage){
        this.baseStats.put(StatType.DAMAGE, damage);
        return self();
    }

    public T baseArmor (int armor){
        this.baseStats.put(StatType.ARMOR, armor);
        return self();
    }

    protected String getName() {
        return name;
    }

    protected Map<StatType, Integer> getBaseStats() {
        return baseStats;
    }
    //Adding all the abilities, inventory items, and equipped items to the unit being built
    protected void populateUnit(Unit unit) {
        for (Ability ability : abilities) {
            unit.addAbility(ability);
        }
        for (Item item : inventory) {
            unit.getInventory().addItem(item);
    }
        for (EquippableItem item : equippedItems) {
            unit.getEquipment().equipItem(item);
        }
    }
}
