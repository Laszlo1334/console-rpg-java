package com.education.inventory;

import com.education.items.Item;
import com.education.items.ConsumableItem;

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
        if(item instanceof ConsumableItem newConsumable){
            for(Item existingItem : this.items){
                if(existingItem.getName().equals(newConsumable.getName())){
                    ConsumableItem existingConsumable = (ConsumableItem) existingItem;
                    existingConsumable.reduceQuantity(1);
                    if(existingConsumable.isItemsLeft()){
                        return;
                    }
                }
            }

        }
        this.items.remove(item);
    }

    public void addItem(Item item){
        if(item instanceof ConsumableItem newConsumable){
            for(Item existingItem : this.items){
                if(existingItem.getName().equals(newConsumable.getName())){
                    ConsumableItem existingConsumable = (ConsumableItem) existingItem;
                    existingConsumable.addQuantity(newConsumable.getQuantity());
                    return;
                }
            }

        }
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
