package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class EmptyScheduleShiftActivity extends AppCompatActivity {

    Button bt_AddShift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_schedule_shift);
        setTitle("Program Creator");
        Util.currentActivity = this;
        Intent intent = getIntent();
        int p = intent.getIntExtra("position",-1);
        ArrayList<Shift> shifts = intent.getParcelableArrayListExtra("shifts");
        ArrayList<WorkDay> days = intent.getParcelableArrayListExtra("days");
        setContentView(R.layout.empty_schedule_shifts);
        RecyclerView shiftData = findViewById(R.id.EmptyShiftData);
        bt_AddShift = findViewById(R.id.bt_AddShift);

        Spinner mySpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(EmptyScheduleShiftActivity.this, R.layout.spinner_test, getResources().getStringArray(R.array.Shifts));
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mySpinner.setAdapter(adapter1);

        bt_AddShift.setOnClickListener(v -> {
            String t = mySpinner.getSelectedItem().toString().toLowerCase();
            Shift s = new Shift();
            s.shift = t;
            shifts.add(s);
            days.get(p).shifts = shifts;
            DataWriter dataWriter = new DataWriter(Util.shiftsDirectory,Util.shiftsFileName);
            try {
                dataWriter.writeScheduleToJson(days);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Util.currentActivity.recreate();
        });

        EmptyScheduleShiftAdapter adapter = new EmptyScheduleShiftAdapter(shifts,days,p);
        shiftData.setAdapter(adapter);
        shiftData.setLayoutManager(new LinearLayoutManager(this));
    }
}