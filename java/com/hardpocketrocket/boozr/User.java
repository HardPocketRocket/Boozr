package com.hardpocketrocket.boozr;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String firstName;
    private String lastName;

    private RealmList<Day> days = new RealmList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){}
}
