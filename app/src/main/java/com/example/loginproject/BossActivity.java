package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BossActivity extends AppCompatActivity {

    Button hireButton,fireButton,createEmptySchedule,viewSchedule,viewEmployees,finalizeSchedule,exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Admin Menu");
        setContentView(R.layout.activity_boss);
        hireButton = findViewById(R.id.hireButton);
        fireButton = findViewById(R.id.fire);
        createEmptySchedule = findViewById(R.id.createEmptySchedule);
        viewEmployees = findViewById(R.id.viewEmployees);
        viewSchedule = findViewById(R.id.ViewSchedule);
        finalizeSchedule = findViewById(R.id.FinalizeSchedule);
        exitButton = findViewById(R.id.Exit);


        exitButton.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        finalizeSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,FinalizedSchedule.class);
            startActivity(intent);
        });


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

        viewSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,ViewSchedule.class);
            startActivity(intent);
        });


    }
}