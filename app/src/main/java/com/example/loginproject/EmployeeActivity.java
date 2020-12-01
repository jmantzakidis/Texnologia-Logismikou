package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EmployeeActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     * New activity that has the employee options
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Employee Activity");
        setContentView(R.layout.activity_employee);
    }
}