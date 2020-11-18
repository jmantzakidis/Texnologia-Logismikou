package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Fire extends AppCompatActivity {

    ArrayList<UserData> data;

    @Override
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Fire Employee");
        setContentView(R.layout.activity_fire);
        RecyclerView userData = findViewById(R.id.userData);
        DataParser dataParser = new DataParser();
        Util util = new Util();
        Util.currentActivity = this;
        try {
            data = dataParser.parseUserData(util.jsonLoader(Util.directory,Util.fileName));
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        if(data.size() == 0){
            Intent intent = new Intent(Util.currentActivity,BossActivity.class);
            Util.currentActivity.startActivity(intent);
            Toast.makeText(getApplicationContext(),"No employee found...",Toast.LENGTH_SHORT).show();
        }
        UserDataAdapter adapter = new UserDataAdapter(data);
        userData.setAdapter(adapter);
        userData.setLayoutManager(new LinearLayoutManager(this));
    }
}
