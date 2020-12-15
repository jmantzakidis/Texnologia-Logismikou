package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class CreateEmptySchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_empty_schedule);
        Util u = new Util();
        try {
            String temp = u.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Empty Program Creator");
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
        EmptyScheduleWeekDayAdapter adapter = new EmptyScheduleWeekDayAdapter(day);
        dayData.setAdapter(adapter);
        dayData.setLayoutManager(new LinearLayoutManager(this));
    }
}