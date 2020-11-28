package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class BossActivity extends AppCompatActivity {

    Button hireButton,fireButton,restrictions,exit,notify,create,view,showEmployees;
    private static final  String TAG ="BossActivity";
    /**
     * In this activity we put two buttons HireButton and FireButton
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Boss Activity");
        setContentView(R.layout.activity_boss);
        hireButton = findViewById(R.id.hireButton);
        fireButton = findViewById(R.id.fire);
        restrictions = findViewById(R.id.restrictions);
        exit = findViewById(R.id.Exit);
        notify = findViewById(R.id.notify);
        create = findViewById(R.id.create);
        view = findViewById(R.id.view);
        showEmployees = findViewById(R.id.showEmployees);

/**
 * This listener creates a new activity that give us the option to fire employees
 */
        fireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Fire.class);
            startActivity(intent);
        });
/**
 *   This listener creates a new activity that give us the option to hire employees
 */
        hireButton.setOnClickListener(v -> {
            Intent intent = new Intent(BossActivity.this,Registration.class);
            startActivity(intent);
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BossActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
    }
}