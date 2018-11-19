package com.hardpocketrocket.boozr;

import io.realm.RealmObject;

public class Drink extends RealmObject {
    private String name;
    private int cost;

    public Drink(String name, int cost, int amount, int alcoholContent) {
        this.name = name;
        this.cost = cost;
    }

    public Drink(){}
}
