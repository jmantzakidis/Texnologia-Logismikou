package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    Button scheduleView,viewSchedule,exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Employee Activity");
        setContentView(R.layout.activity_employee);
        scheduleView = findViewById(R.id.emView);
        exitButton = findViewById(R.id.emExit);
        viewSchedule = findViewById(R.id.emViewCompleteSchedule);

        viewSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeActivity.this,ViewSchedule.class);
            startActivity(intent);
        });

        exitButton.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
        scheduleView.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeActivity.this,Schedule.class);
            startActivity(intent);
        });
    }
}