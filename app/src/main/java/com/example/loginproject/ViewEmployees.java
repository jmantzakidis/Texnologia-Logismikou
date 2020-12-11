package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ViewEmployees extends AppCompatActivity {
    ArrayList<UserData> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employees);
        RecyclerView EmployeeData = findViewById(R.id.EmployeeData);
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
        EmployeeDataAdapter adapter = new EmployeeDataAdapter(data);
        EmployeeData.setAdapter(adapter);
        EmployeeData.setLayoutManager(new LinearLayoutManager(this));
    }
}