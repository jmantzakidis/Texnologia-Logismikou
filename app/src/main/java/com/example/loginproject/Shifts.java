package com.example.loginproject;

public class Shifts {
    private int hoursOfMorning;
    private int housOfEvening;
    private int hoursOfNight;

    Shifts()
    {
        this.hoursOfMorning=0;
        this.hoursOfNight=0;
        this.housOfEvening=0;
    }
    Shifts(int hoursOfMorning,int hoursOfEvening , int hoursOfNight )
    {
        this.hoursOfMorning=hoursOfMorning;
        this.hoursOfNight=hoursOfNight;
        this.housOfEvening=hoursOfEvening;
    }
    public void setHoursOfMorning(int i)
    {
        this.hoursOfMorning=i;
    }
    public void setHoursOfEvening(int i)
    {
        this.housOfEvening=i;
    }
    public void setHoursOfNight(int i)
    {
        this.hoursOfNight=i;
    }
    public int getHoursOfMorning()
    {
        return this.hoursOfMorning;
    }
    public int getHoursOfEvening()
    {
        return this.housOfEvening;
    }
    public int getHoursOfNight()
    {
        return this.hoursOfNight;
    }
}
