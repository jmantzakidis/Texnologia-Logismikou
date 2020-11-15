package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button employee;
    private Button Boss;
    private Button about;
    private Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        employee =(Button) findViewById(R.id.employee);
        Boss =(Button) findViewById(R.id.Boss);
        about = (Button) findViewById(R.id.AboutUs);
        exit = (Button) findViewById(R.id.exit);

        about.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,AboutUs.class);
            startActivity(intent);
        });
        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
        Boss.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,BossActivity.class);
            startActivity(intent);
        });
        employee.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,EmployeeActivity.class);
            startActivity(intent);
        });


    }
}