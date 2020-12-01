package com.example.loginproject;

public class CompanySettings {

    private int hoursPerDay;
    private int daysOfWeek;
    private int weeks;

    public CompanySettings()
    {
        this.daysOfWeek=0;
        this.hoursPerDay=0;
        this.weeks=0;

    }
    public CompanySettings(int hoursPerDay,int daysOfWeek,int weeks)
    {
        this.hoursPerDay=hoursPerDay;
        this.daysOfWeek=daysOfWeek;
        this.weeks=weeks;
    }

    public void setHoursPerWeek(int hoursPerWeek)
    {
        this.hoursPerDay=hoursPerWeek;
    }
    public void setDaysOfWeek(int daysOff)
    {
        this.daysOfWeek=daysOff;
    }

    public int getHoursPerDay()
    {
        return this.hoursPerDay;
    }
    public int getDaysOfWeek()
    {
        return this.daysOfWeek;
    }
    public void setWeeks(int weeks)
    {
        this.weeks=weeks;
    }
    public int getWeeks()
    {
        return this.weeks;
    }
}
