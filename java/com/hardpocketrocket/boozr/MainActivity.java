package com.hardpocketrocket.boozr;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Calendar currentDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> user = realm.where(User.class).findAll();

        if(user.size() == 0){
            launchNewUserDialog();
        }

        CardView userInfoLayout = findViewById(R.id.user_info_card);
        CardView addDrinkLayout = findViewById(R.id.add_drink_card);
        CardView graphViewLayout = findViewById(R.id.graph_card);
        CardView twitterPostLayout = findViewById(R.id.twitter_card);

        userInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addDrinkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void daysSinceLastLogin(){

    }

    private void launchNewUserDialog(){
            LayoutInflater inflater = LayoutInflater.from(this);
            final View newUserDialog = inflater.inflate(R.layout.activity_new_user,null);
            final EditText firstName = newUserDialog.findViewById(R.id.first_name);
            final EditText lastName = newUserDialog.findViewById(R.id.last_name);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(newUserDialog);

            builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

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
