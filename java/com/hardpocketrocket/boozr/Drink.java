package com.hardpocketrocket.boozr;

import io.realm.RealmObject;

public class Drink extends RealmObject {
    private String name;
    private int cost;
    private int amount;
    private int alcoholContent;

    public Drink(String name, int cost, int amount, int alcoholContent) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
        this.alcoholContent = alcoholContent;
    }

    public Drink(){}
}
