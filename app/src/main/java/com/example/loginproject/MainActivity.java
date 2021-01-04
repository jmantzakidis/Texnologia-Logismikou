package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter =5;

    ArrayList<UserData> userData = new ArrayList<>();

    HashMap<String,String> userNamePassword = new HashMap<>();
    HashMap<String,UserData> userNameUserData = new HashMap<>();
    @Override
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login Menu");
        setContentView(R.layout.activity_main);
        Util context = new Util();
        context.setContext(getApplicationContext());

        Util util = new Util();
        DataParser dataParser = new DataParser();
        try {
            userData = dataParser.parseUserData(util.jsonLoader(Util.directory,Util.fileName));

            for(UserData user : userData){
                userNameUserData.put(user.userName,user);
                userNamePassword.put(user.userName,user.password);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        name = findViewById(R.id.Name);
        password = findViewById(R.id.Password);
        info = findViewById(R.id.info);
        login = findViewById(R.id.Login);
        info.setText("Number of Attempts remaining :5 ");
        login.setOnClickListener(v -> Validate(name.getText().toString(), password.getText().toString()));
    }

    @SuppressLint("SetTextI18n")
    private void Validate(String username , String passWord)
    {
        if(username.equals("Admin") && passWord.equals("1234"))
        {
            Intent intent = new Intent(MainActivity.this,BossActivity.class);
            startActivity(intent);
        }
        else if(userNamePassword.containsKey(username)){
            if(userNamePassword.get(username).equals(passWord)) {
                Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
                Util.currentUser = userNameUserData.get(username);
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
