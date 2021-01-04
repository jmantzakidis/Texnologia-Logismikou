package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FinalizedSchedule extends AppCompatActivity {

    ArrayList<UserData> userData;
    private ArrayList<Shift> shifts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalized_schedule);


        DataParser dataParser = new DataParser();
        Util util = new Util();
        Util.currentActivity = this;
        try {
            userData = dataParser.parseUserData(util.jsonLoader(Util.directory,Util.fileName));
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        Util u = new Util();
        try {
            String temp = u.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_schedule);
        setTitle("Weekly Program");
        String JsonData = null;
        try {
            JsonData = u.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Util.currentActivity = this;
        ArrayList<WorkDay> days = null;
        try {
            days = dataParser.parseWeekData(JsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Restrictions restrictions = new Restrictions();
        int p,res;
        Random rand = new Random();
        UserData user;
        int avg = 0;
        int median;

        if(userData.size() % 2 == 0){
            median = userData.size()/2;
        }else
            median = userData.size() /2 + 1 ;

        for(WorkDay day : days){
            Collections.sort(userData);
            System.out.println(userData.get(0).daysWorked);
            for(Shift shift : day.shifts){
                boolean found = false;
                if(shift.employeeName.equals("")){
                    while(!found){
                        p = rand.nextInt(userData.size());
                        user = userData.get(p);
                        res = restrictions.checkDays(user,days,days.indexOf(day),shift.shift);

                        System.out.println(user.name + " " + user.surName + " " + "daysWorked" + user.daysWorked);


                        if(user.daysWorked - userData.get(userData.size()-1).daysWorked >= 1)
                            continue;
//                        if(user.daysWorked > userData.get(median).daysWorked && userData.get(median).daysWorked !=0)
//                            continue;
//                        if(user.daysWorked == userData.get(0).daysWorked)
//                            continue;

                        switch (res){
                            case Restrictions.SUCCESS_CODE:
                                found = true;
                                user.daysWorked += 1;
                                shift.employeeName = user.name + " " +user.surName;
                                break;
                            case Restrictions.DOUBLE_SHIFT_CODE:
                                break;
                            case Restrictions.SAME_DAY_CODE:
                                break;
                        }
                    }
                }
//                else{
//                    for(UserData user1 : userData){
//                        if(shift.employeeName.equals(user1.name +" "+ user1.surName)){
//                            user1.daysWorked += 1;
//                        }
//                    }
//                }
            }
            int sum = 0;
            for(UserData user1 : userData){
                sum += user1.daysWorked;
            }
            avg = sum/userData.size();
        }


        DataWriter dataWriter = new DataWriter(Util.shiftsDirectory,Util.shiftsFileName);
        try {
            dataWriter.writeScheduleToJson(days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        DataWriter dataWriter1 = new DataWriter(Util.directory,Util.fileName);
        try {
            dataWriter1.writeToJson(userData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        for(WorkDay day : days){
//            for(Shift shift : day.shifts) {
//                System.out.println("Day = " + day.day + " Shift = " + shift.shift + " Employee = " + shift.employeeName);
//            }
//        }
    }
}