package com.hardpocketrocket.boozr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hardpocketrocket.boozr.Model.Day;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class GraphActivity extends AppCompatActivity {
    private GraphView lineGraph;
    private GraphView barGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        makeGraphs();
    }

    private void makeGraphs() {
        lineGraph = findViewById(R.id.line_graph);
        barGraph = findViewById(R.id.bar_graph);

        Realm.getDefaultInstance().beginTransaction();
        List<Day> days = Realm.getDefaultInstance().copyFromRealm(Realm.getDefaultInstance().where(Day.class).findAll());
        Realm.getDefaultInstance().commitTransaction();

        if (days.size() >= 14) {
            while (days.size() >= 14) {
                days.remove(0);
            }
        }

        ArrayList<DataPoint> numberOfDrinksData = new ArrayList<>();
        ArrayList<DataPoint> totalSpentData = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        numberOfDrinksData.add(new DataPoint(0,0));
        totalSpentData.add(new DataPoint(0,0));
        dates.add("Days");

        for (int i = 0; i < days.size(); i++) {
            numberOfDrinksData.add(new DataPoint(i + 1, days.get(i).getNumberOfDrinks()));
            totalSpentData.add(new DataPoint(i + 1, days.get(i).getTotalCostOfDrinks()));
            dates.add(days.get(i).getDate().toString());
        }

        LineGraphSeries<DataPoint> drinksSeries = new LineGraphSeries<>(numberOfDrinksData.toArray(new DataPoint[0]));
        lineGraph.addSeries(drinksSeries);

        BarGraphSeries<DataPoint> costSeries = new BarGraphSeries<>(totalSpentData.toArray(new DataPoint[0]));
        barGraph.addSeries(costSeries);
        costSeries.setSpacing(10);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(lineGraph);
        staticLabelsFormatter.setHorizontalLabels(dates.toArray(new String[0]));
        lineGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        staticLabelsFormatter = new StaticLabelsFormatter(barGraph);
        staticLabelsFormatter.setHorizontalLabels(dates.toArray(new String[0]));
        barGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }
}
