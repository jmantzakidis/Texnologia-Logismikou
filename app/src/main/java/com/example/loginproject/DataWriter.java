package com.example.loginproject;

import android.content.Context;
import android.util.JsonWriter;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.auth.User;
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

public class DataWriter {

    private String filePath = Util.directory;
    private String fileName = Util.fileName;

    public void writeToJson(UserData userData,Context context) throws IOException, JSONException {
        File jsonDir = new File(context.getFilesDir(),filePath);
        File fileJson = new File(jsonDir,fileName);
        if(!jsonDir.exists()) {
            jsonDir.mkdir();
            fileJson.createNewFile();
            //File fileJson = new File(jsonDir,fileName);
        }
        fileJson.createNewFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileJson));
        StringBuilder builder = new StringBuilder();
        String line = null;
        JSONArray dataArray = null;
        JSONObject newObject = null;
        JSONObject tempJSONObject = new JSONObject();

        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        bufferedReader.close();
        if(builder.length()>0) {
            JSONObject jsonObject = new JSONObject(builder.toString());
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

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJson));
        bufferedWriter.write(tempJSONObject.toString());
        bufferedWriter.close();

    }
    }


