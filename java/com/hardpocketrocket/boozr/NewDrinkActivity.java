package com.hardpocketrocket.boozr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewDrinkActivity extends AppCompatActivity {
    private Spinner alcoholTypesSpinner;
    private ArrayList<String> alcoholTypes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);

        ImageView alcoholImage = findViewById(R.id.alcohol_type_image);

        populateTypes();
        alcoholTypesSpinner = findViewById(R.id.alcohol_types_spinner);
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alcoholTypes);
        alcoholTypesSpinner.setAdapter(dataAdapter);

        alcoholTypesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alcoholImage.setImageResource(R.drawable.beer);
                } else if(position == 1){
                    alcoholImage.setImageResource(R.drawable.wine);
                }else if(position == 2){
                    alcoholImage.setImageResource(R.drawable.champagne);
                }else if(position == 3){
                    alcoholImage.setImageResource(R.drawable.whiskey);
                }else if(position == 4){
                    alcoholImage.setImageResource(R.drawable.vodka);
                }else if(position == 5){
                    alcoholImage.setImageResource(R.drawable.rum);
                }else if(position == 6){
                    alcoholImage.setImageResource(R.drawable.cocktail);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void populateTypes() {
        alcoholTypes.add("Beer");
        alcoholTypes.add("Wine");
        alcoholTypes.add("Champagne");
        alcoholTypes.add("Whiskey");
        alcoholTypes.add("Vodka");
        alcoholTypes.add("Rum");
        alcoholTypes.add("Cocktail");
    }
}
