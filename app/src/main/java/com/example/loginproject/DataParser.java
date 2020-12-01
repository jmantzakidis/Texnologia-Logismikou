package com.example.loginproject;

import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class DataParser {

    public ArrayList <UserData> parseUserData(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray registrations = jsonObject.getJSONArray("Registrations");
        ArrayList<UserData> registrationData = new ArrayList<>();
        JSONObject temp = null;
        UserData tempData = null;
        for(int i=0; i < registrations.length(); i++){
            temp = registrations.getJSONObject(i);
            tempData = new UserData();
            tempData.name = temp.getString("name");
            tempData.surName = temp.getString("surName");
            tempData.email = temp.getString("email");
            tempData.userName = temp.getString("userName");
            tempData.mobile = temp.getString("mobile");
            tempData.password = temp.getString("password");
            tempData.specialty = temp.getString("specialty");
            registrationData.add(tempData);
        }
        return registrationData;
    }
}
