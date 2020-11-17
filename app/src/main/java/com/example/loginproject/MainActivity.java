package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter =5;
    @Override
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.Name);
        password = findViewById(R.id.Password);
        info = findViewById(R.id.info);
        login = findViewById(R.id.Login);
        info.setText("Number of Attempts remaining :5 ");

        Intent intent = new Intent(MainActivity.this,Registration.class);
        startActivity(intent);
        login.setOnClickListener(v -> Validate(name.getText().toString(), password.getText().toString()));
    }

    @SuppressLint("SetTextI18n")
    private void Validate(String username , String passWord)
    {
        if(username.equals("Admin") && passWord.equals("1234"))
        {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            info.setText("Number of attempts remaining "+String.valueOf(counter));
            if(counter == 0)
            {
                login.setEnabled(false);
            }
        }
    }
}
