package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BossActivity extends AppCompatActivity {

    Button hireButton,fireButton,createEmptySchedule,viewSchedule,viewEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Admin Activity");
        setContentView(R.layout.activity_boss);
        hireButton = findViewById(R.id.hireButton);
        fireButton = findViewById(R.id.fire);
        createEmptySchedule = findViewById(R.id.createEmptySchedule);
//        viewSchedule = findViewById(R.id.view);
        viewEmployees = findViewById(R.id.viewEmployees);

        fireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Fire.class);
            startActivity(intent);
        });

        hireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Registration.class);
            startActivity(intent);
        });

        createEmptySchedule.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,CreateEmptySchedule.class);
            startActivity(intent);
        });

        viewEmployees.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,ViewEmployee.class);
            startActivity(intent);
        });


//        viewSchedule.setOnClickListener(v -> {
//            Intent intent = new Intent(BossActivity.this,ViewSchedule.class);
//            startActivity(intent);
//        });

    }
}