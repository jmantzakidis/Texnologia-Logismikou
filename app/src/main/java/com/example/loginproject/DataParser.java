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
            tempData.contract = temp.getString("contract");
            tempData.daysWorked = temp.getInt("daysWorked");
            registrationData.add(tempData);
        }
        return registrationData;
    }

    public ArrayList <WorkDay> parseWeekData(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray registrations = jsonObject.getJSONArray("Week");
        ArrayList<WorkDay> registrationData = new ArrayList<>();
        JSONObject tempJsonDay = null;
        for(int i=0; i < registrations.length(); i++){
            tempJsonDay = registrations.getJSONObject(i);
            WorkDay tempDay = new WorkDay(tempJsonDay.getString("Day"));
            ArrayList<Shift> shifts = new ArrayList<>();
            JSONArray tempShifts = tempJsonDay.getJSONArray("Shifts");
            for(int j=0; j < tempShifts.length(); j++){
                JSONObject tempJsonShift = tempShifts.getJSONObject(j);
                Shift tempShift = new Shift();
                tempShift.shift = tempJsonShift.getString("time");
                tempShift.employeeName = tempJsonShift.getString("employee");
                tempShift.status = tempJsonShift.getString("status");
                shifts.add(tempShift);
            }
            tempDay.shifts = shifts;
            registrationData.add(tempDay);
        }
        return registrationData;
    }
}
