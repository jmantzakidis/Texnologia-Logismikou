package com.example.loginproject;

import android.content.Context;
import android.util.JsonWriter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DataWriter{

    private final String filePath = Util.directory;
    private final String fileName = Util.fileName;

    public void writeToJson(UserData userData) throws IOException, JSONException {

        Util util = new Util();
        String jsonString = util.jsonLoader(filePath,fileName);
        JSONArray dataArray = null;
        JSONObject newObject = null;
        JSONObject tempJSONObject = new JSONObject();

        if(jsonString.length()>0) {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray oldArray = jsonObject.getJSONArray("Registrations");
            newObject = new JSONObject();
            newObject.put("name",userData.name);
            newObject.put("surName",userData.surName);
            newObject.put("email",userData.email);
            newObject.put("userName",userData.userName);
            newObject.put("mobile",userData.mobile);
            newObject.put("password",userData.password);
            newObject.put("specialty",userData.specialty);
            oldArray.put(newObject);
            tempJSONObject.put("Registrations",oldArray);
        }else {
            newObject = new JSONObject();
            newObject.put("name",userData.name);
            newObject.put("surName",userData.surName);
            newObject.put("email",userData.email);
            newObject.put("userName",userData.userName);
            newObject.put("mobile",userData.mobile);
            newObject.put("password",userData.password);
            newObject.put("specialty",userData.specialty);
            dataArray = new JSONArray();
            dataArray.put(newObject);
            tempJSONObject.put("Registrations",dataArray);
        }
        util.jsonWriter(tempJSONObject,filePath,fileName);
    }
    public void writeToJson(ArrayList<UserData> userData) throws IOException, JSONException{
        Util util = new Util();
        JSONArray dataArray = new JSONArray();
        JSONObject newObject = null;
        JSONObject tempJSONObject = new JSONObject();
        for(UserData user : userData){
            newObject = new JSONObject();
            newObject.put("name",user.name);
            newObject.put("surName",user.surName);
            newObject.put("email",user.email);
            newObject.put("userName",user.userName);
            newObject.put("mobile",user.mobile);
            newObject.put("password",user.password);
            newObject.put("specialty",user.specialty);
            dataArray.put(newObject);
        }
        tempJSONObject.put("Registrations",dataArray);
        util.jsonWriter(tempJSONObject,filePath,fileName);
    }
}


