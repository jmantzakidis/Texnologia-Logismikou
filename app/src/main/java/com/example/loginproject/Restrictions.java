package com.example.loginproject;

import android.widget.Toast;

import java.util.ArrayList;

public class Restrictions {


    public Boolean checkDays(int day, ArrayList<WorkDay>days,String time){

        boolean flag = true;
        for(Shift s : days.get(day).shifts){
            if(s.employeeName.equals(Util.currentUser.name + " " + Util.currentUser.surName)){
                Toast.makeText(Util.context,"You can't get more than one shift",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if(day >= 1){
            ArrayList<Shift> shifts = days.get(day-1).shifts;
            for(Shift shift : shifts){
                if(shift.shift.equals("night")){
                    if(time.equals("morning")){
                        Toast.makeText(Util.context,"You can't apply for morning shift \n if you worked at night",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
