package com.education.Items;

import com.education.Units.Unit;

import java.util.Objects;
import java.util.UUID;

public abstract class Item {
    private final UUID id;
    private String name;
    private int price;
    private ItemRarity rarity;
    private boolean usable;

    public Item(String name, int price, ItemRarity rarity, boolean usable) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.rarity = rarity;
        this.usable = usable;
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item that = (Item) o;
        return (Objects.equals(this.id, that.getId()));

    }

    @Override
    public int hashCode (){
        return Objects.hash(this.id);
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isUsable() {
        return usable;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }
}
