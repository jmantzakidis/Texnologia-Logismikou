package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUs extends AppCompatActivity {

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About Us");
        setContentView(R.layout.activity_about_us);

        Back = findViewById(R.id.back);
        Back.setOnClickListener(v -> {
            Intent intent = new Intent(AboutUs.this,SecondActivity.class);
            startActivity(intent);
        });
    }
}