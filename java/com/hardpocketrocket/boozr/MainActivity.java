package com.hardpocketrocket.boozr;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDate;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> users = realm.where(User.class).findAll();

        //====================================CODE TO DELETE THE LAST DATE==========================
//        Realm.getDefaultInstance().beginTransaction();
//        User u = Realm.getDefaultInstance().where(User.class).findFirst();
//        RealmList<Day> d = u.getDays();
//        d.deleteLastFromRealm();
//        Realm.getDefaultInstance().commitTransaction();
        //==========================================================================================

        if (users.size() == 0) {
            launchNewUserDialog();
        } else {
            user = users.first();
            int daysSinceLastLogin = user.daysSinceLastLogin();

            Realm.getDefaultInstance().beginTransaction();
            for (int i = 0; i < daysSinceLastLogin; i++) {
                user.addDay(user.dateOfLastLogin().plusDays((long) (i + 1)));
            }
            Realm.getDefaultInstance().commitTransaction();
        }

        CardView userInfoLayout = findViewById(R.id.user_info_card);
        CardView addDrinkLayout = findViewById(R.id.add_drink_card);
        CardView graphViewLayout = findViewById(R.id.graph_card);
        CardView twitterPostLayout = findViewById(R.id.twitter_card);

        userInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });

        addDrinkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewDrinkActivity.class);
                startActivity(intent);
            }
        });

        graphViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        twitterPostLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void launchNewUserDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        final View newUserDialog = inflater.inflate(R.layout.activity_new_user, null);
        final EditText firstName = newUserDialog.findViewById(R.id.first_name);
        final EditText lastName = newUserDialog.findViewById(R.id.last_name);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(newUserDialog);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                user = new User(firstName.getText().toString(), lastName.getText().toString());
                user.addDay(LocalDate.now());

                Realm.getDefaultInstance().beginTransaction();
                Realm.getDefaultInstance().insert(user);
                Realm.getDefaultInstance().commitTransaction();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
