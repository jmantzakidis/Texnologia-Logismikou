package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EmployeeActivity extends AppCompatActivity {

    Button scheduleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Employee Activity");
        setContentView(R.layout.activity_employee);
        scheduleView = findViewById(R.id.emView);
        scheduleView.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeActivity.this,Schedule.class);
            startActivity(intent);
        });

    }
}