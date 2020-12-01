package com.example.loginproject;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class Restrictions extends AppCompatActivity {
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restrictions);
        backButton=findViewById(R.id.bt_back);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Restrictions.this,BossActivity.class);
            startActivity(intent);
        });
    }

}