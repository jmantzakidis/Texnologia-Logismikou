package com.example.loginproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class notification2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String age = bundle.getString("age");
            TextView tvName = findViewById(R.id.tvName);
            TextView tvAge = findViewById(R.id.tvAge);
            tvName.setText(name);
            tvAge.setText(age);
        }
    }
}