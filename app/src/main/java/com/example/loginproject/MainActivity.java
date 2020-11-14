package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView info;
    private Button Login;
    private int counter =5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText) findViewById(R.id.Name);
        Password = (EditText) findViewById(R.id.Password);
        info = (TextView) findViewById(R.id.info);
        Login = (Button) findViewById(R.id.Login);
        info.setText("Number of Attemps remaining :5 ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(), Password.getText().toString());

            }
        });
    }
    private void Validate(String username ,String passWord)
    {
        if(username.equals("Admin") && passWord.equals("1234"))
        {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            info.setText("No of attempts remaining "+String.valueOf(counter));
            if(counter == 0)
            {
                Login.setEnabled(false);
            }
        }
    }
}
