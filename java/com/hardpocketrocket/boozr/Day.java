package com.hardpocketrocket.boozr;

import java.time.LocalDate;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Day extends RealmObject {
    private int numberOfDrinks;
    private int totalAmountOfDrinks;
    private int totalCostOfDrinks;

    private String date;
    private RealmList<Drink> drinks = new RealmList<>();

    public Day(LocalDate date) {
        this.date = date.toString();
        this.numberOfDrinks = 0;
        this.totalAmountOfDrinks = 0;
        this.totalCostOfDrinks = 0;
    }

    public Day() {
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }
}
