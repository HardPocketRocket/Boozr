package com.hardpocketrocket.boozr;

import java.time.LocalDate;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String firstName;
    private String lastName;

    private RealmList<Day> days = new RealmList<>();

    public void addDay(LocalDate date){
        days.add(new Day(date));
    }

    public LocalDate getDayOfLastLogin(){
        return days.get(days.size() - 1).getDate();
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
}
