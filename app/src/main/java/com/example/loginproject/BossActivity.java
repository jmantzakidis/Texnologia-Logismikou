package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BossActivity extends AppCompatActivity {

    Button hireButton,fireButton,showEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Boss Activity");
        setContentView(R.layout.activity_boss);
        hireButton = findViewById(R.id.hireButton);
        fireButton = findViewById(R.id.fire);
        showEmployees = findViewById(R.id.showEmployees);
        fireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Fire.class);
            startActivity(intent);
        });

        hireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Registration.class);
            startActivity(intent);
        });
        showEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BossActivity.this,ViewEmployees.class);
                startActivity(intent);
            }
        });
    }
}