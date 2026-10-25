package com.education.inventory;

import com.education.items.Item;
import com.education.items.consumables.ConsumableItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Inventory {
    private final UUID id;
    private final List<Item> items;

    public Inventory() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void addItem(Item item){

        this.items.add(item);
    }

    public boolean hasItem(Item item){
        return this.items.contains(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<ConsumableItem> getConsumableItems(){
        return items.stream().
                filter(item -> item instanceof ConsumableItem)
                .map(ConsumableItem.class::cast) //cast from Item to ConsumableItem
                .toList();
    }

    public UUID getId() {
        return id;
    }
}
