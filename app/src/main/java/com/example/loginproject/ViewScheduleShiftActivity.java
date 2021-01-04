package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ViewScheduleShiftActivity extends AppCompatActivity {

    public ArrayList<UserData> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Schedule");
        Util.currentActivity = this;
        Intent intent = getIntent();
        setContentView(R.layout.activity_view_schedule_shift);
        int p = intent.getIntExtra("position",-1);
        ArrayList<Shift> shifts = intent.getParcelableArrayListExtra("shifts");
        ArrayList<WorkDay> days = intent.getParcelableArrayListExtra("days");
        RecyclerView shiftData = findViewById(R.id.shiftData);
        DataParser dataParser = new DataParser();
        Util util = new Util();
        Util.currentActivity = this;
        try {
            data = dataParser.parseUserData(util.jsonLoader(Util.directory,Util.fileName));
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        ViewScheduleShiftAdapter adapter = new ViewScheduleShiftAdapter(shifts,days,p,data);
        shiftData.setAdapter(adapter);
        shiftData.setLayoutManager(new LinearLayoutManager(this));
    }
}