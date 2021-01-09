package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Weekly Program");
        Util.currentActivity = this;
        Intent intent = getIntent();
        setContentView(R.layout.activity_shift);

        int p = intent.getIntExtra("position",-1);
        ArrayList<Shift> shifts = intent.getParcelableArrayListExtra("shifts");
        ArrayList<WorkDay> days = intent.getParcelableArrayListExtra("days");

        RecyclerView shiftData = findViewById(R.id.shiftData);

        setTitle(days.get(p).day);
        ShiftAdapter adapter = new ShiftAdapter(shifts,days,p);
        shiftData.setAdapter(adapter);
        shiftData.setLayoutManager(new LinearLayoutManager(this));

    }
}