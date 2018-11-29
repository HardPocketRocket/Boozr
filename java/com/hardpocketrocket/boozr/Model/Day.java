package com.hardpocketrocket.boozr.Model;

import java.time.LocalDate;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Day extends RealmObject {
    private int numberOfDrinks;
    private int totalCostOfDrinks;

    private String date;
    private RealmList<Drink> drinks = new RealmList<>();

    public void addDrink(Drink drink){
        drinks.add(drink);
        numberOfDrinks++;
        totalCostOfDrinks += drink.getCost();
    }

    public Day(LocalDate date) {
        this.date = date.toString();
        this.numberOfDrinks = 0;
        this.totalCostOfDrinks = 0;
    }

    public Day() {
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }

    public int getTotalCostOfDrinks() {
        return totalCostOfDrinks;
    }
}
