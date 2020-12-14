package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util u = new Util();
        try {
            String temp = u.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_schedule);
        setTitle("Weekly Program");
        String JsonData = null;
        try {
            JsonData = u.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Util.currentActivity = this;
        DataParser dataParser = new DataParser();
        ArrayList<WorkDay> day = null;
        try {
            day = dataParser.parseWeekData(JsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RecyclerView dayData = findViewById(R.id.dayData);
        WeekDayAdapter adapter = new WeekDayAdapter(day);
        dayData.setAdapter(adapter);
        dayData.setLayoutManager(new LinearLayoutManager(this));

    }
}