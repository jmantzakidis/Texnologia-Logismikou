package com.example.loginproject;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Restrictions {

//-1 = double shift //-2 same day // 0 success

    public final static int DOUBLE_SHIFT_CODE = -1;
    public final static int SAME_DAY_CODE = -2;
    public final static int SUCCESS_CODE = 0;
    public final static String SAME_DAY_MESSAGE = "You can't get more than one shift";
    public final static String DOUBLE_SHIFT = "You can't apply for morning shift \n if you worked at night";
    public final static String SUCCESS_APPLY = "You have applied successfully";

    public Integer checkDays(int day, ArrayList<WorkDay>days,String time){


        for(Shift s : days.get(day).shifts){
            if(s.employeeName.equals(Util.currentUser.name + " " + Util.currentUser.surName)){
//                Toast.makeText(Util.context,"You can't get more than one shift",Toast.LENGTH_SHORT).show();
                return SAME_DAY_CODE;
            }
        }
        if(day >= 1){
            ArrayList<Shift> shifts = days.get(day-1).shifts;
            for(Shift shift : shifts){
                if(shift.shift.equals("night")){
                    if(time.equals("morning")){
//                        Toast.makeText(Util.context,"You can't apply for morning shift \n if you worked at night",Toast.LENGTH_SHORT).show();
                        return DOUBLE_SHIFT_CODE;
                    }
                }
            }
        }
        return SUCCESS_CODE;
    }

    public Integer checkDays(UserData user,ArrayList<WorkDay>days,int dayIndex,String shiftTime){

        for(Shift s : days.get(dayIndex).shifts){
            if(s.employeeName.equals(user.name + " " + user.surName)){
                return SAME_DAY_CODE;
            }
        }
        if(dayIndex >= 1){
            ArrayList<Shift> shifts = days.get(dayIndex-1).shifts;
            for(Shift shift : shifts){
                if(shift.shift.equals("night")){
                    if(shiftTime.equals("morning") && shift.employeeName.equals(user.name + user.surName)){
                        return DOUBLE_SHIFT_CODE;
                    }
                }
            }
        }
        return SUCCESS_CODE;
    }
}
