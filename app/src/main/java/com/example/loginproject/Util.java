package com.example.loginproject;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

    public static String directory = "userData";
    public static String fileName ="userData.json";
    public static String shiftsFileName ="shifts.json";
    public static String shiftsDirectory = "shifts";
    public static Context context;
    public static AppCompatActivity currentActivity;
    public static String MORNING_SHIFT = "morning";
    public static String AFTERNOON_SHIFT = "afternoon";
    public static String NIGHT_SHIFT = "night";
    public static UserData currentUser;
    public static ArrayList<WorkDay> days;

    public void setContext(Context context){
        this.context = context;
    }

    public String jsonLoader(String filePath,String fileName) throws IOException {
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

        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

    public void jsonWriter(JSONObject jsonObject,String filePath,String fileName) throws JSONException, IOException {

        File jsonDir = new File(context.getFilesDir(),filePath);
        File fileJson = new File(jsonDir,fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJson));
        bufferedWriter.write(jsonObject.toString(4));
        bufferedWriter.close();
    }
}
