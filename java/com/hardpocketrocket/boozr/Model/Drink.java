package com.hardpocketrocket.boozr.Model;

import io.realm.RealmObject;

public class Drink extends RealmObject {
    private String name;
    private int cost;

    public Drink(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Drink(){}

    public int getCost() {
        return cost;
    }
}
