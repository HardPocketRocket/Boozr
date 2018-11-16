package com.hardpocketrocket.boozr;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Day extends RealmObject {
    private int numberOfDrinks;
    private int totalAmountOfDrinks;
    private int totalCostOfDrinks;

    private Date date;
    private RealmList<Drink> drinks  = new RealmList<>();

    public Day(Date date, int numberOfDrinks, int totalAmountOfDrinks, int totalCostOfDrinks) {
        this.date = date;
        this.numberOfDrinks = numberOfDrinks;
        this.totalAmountOfDrinks = totalAmountOfDrinks;
        this.totalCostOfDrinks = totalCostOfDrinks;
    }

    public Day(){}
}
