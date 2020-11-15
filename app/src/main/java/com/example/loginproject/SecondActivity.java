package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button employee;
    private Button boss;
    private Button about;
    private Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu Option");
        setContentView(R.layout.activity_second);

        employee = findViewById(R.id.employee);
        boss = findViewById(R.id.Boss);
        about = findViewById(R.id.AboutUs);
        exit = findViewById(R.id.exit);

        about.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,AboutUs.class);
            startActivity(intent);
        });
        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
        boss.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,BossActivity.class);
            startActivity(intent);
        });
        employee.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,EmployeeActivity.class);
            startActivity(intent);
        });


    }
}