package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class notification extends AppCompatActivity {
    EditText etName, etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("age", age);
                Intent intent = new Intent(notification.this, notification2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
