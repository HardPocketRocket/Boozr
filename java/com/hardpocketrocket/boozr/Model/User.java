package com.hardpocketrocket.boozr.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String firstName;
    private String lastName;

    private RealmList<Day> days = new RealmList<>();

    public void addDay(LocalDate date){
        days.add(new Day(date));
    }

    public int daysSinceLastLogin(){
        LocalDate dayOfLastLogin = dateOfLastLogin();
        LocalDate today = LocalDate.now();

        int daysBetween = (int)dayOfLastLogin.until(today, ChronoUnit.DAYS);
        return daysBetween;
    }

    public LocalDate dateOfLastLogin(){
        return this.days.get(days.size() - 1).getDate();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RealmList<Day> getDays() {
        return days;
    }
}
