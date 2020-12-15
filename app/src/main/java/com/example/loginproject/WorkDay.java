package com.example.loginproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class WorkDay implements Parcelable {

    ArrayList<Shift> shifts;
    String day;

    public WorkDay() {
    }

    public WorkDay(String day) {
        this.day = day;
        shifts = new ArrayList<>();
    }

    protected WorkDay(Parcel in) {
        shifts = in.createTypedArrayList(Shift.CREATOR);
        day = in.readString();
    }

    public static final Creator<WorkDay> CREATOR = new Creator<WorkDay>() {
        @Override
        public WorkDay createFromParcel(Parcel in) {
            return new WorkDay(in);
        }

        @Override
        public WorkDay[] newArray(int size) {
            return new WorkDay[size];
        }
    };

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(shifts);
        dest.writeString(day);
    }
}
