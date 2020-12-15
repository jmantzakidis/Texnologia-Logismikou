package com.example.loginproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Shift implements Parcelable {

   public String shift;
   public String employeeName;
   public String status;

    public Shift() {
        status = "pending";
        employeeName = "";
    }

    public Shift(String shift, String employeeName) {
        this.shift = shift;
        this.employeeName = employeeName;
        status = "pending";
    }

    protected Shift(Parcel in) {
        shift = in.readString();
        employeeName = in.readString();
        status = in.readString();
    }

    public static final Creator<Shift> CREATOR = new Creator<Shift>() {
        @Override
        public Shift createFromParcel(Parcel in) {
            return new Shift(in);
        }

        @Override
        public Shift[] newArray(int size) {
            return new Shift[size];
        }
    };

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shift);
        dest.writeString(employeeName);
        dest.writeString(status);
    }
}
