package com.hardpocketrocket.boozr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    CardView userInfoLayout;
    CardView addDrinkLayout;
    CardView graphViewLayout;
    CardView twitterPostLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfoLayout = findViewById(R.id.user_info_card);
        addDrinkLayout = findViewById(R.id.add_drink_card);
        graphViewLayout = findViewById(R.id.graph_card);
        twitterPostLayout = findViewById(R.id.twitter_card);

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
}
