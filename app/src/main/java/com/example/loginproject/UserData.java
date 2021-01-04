package com.example.loginproject;

public class UserData implements Comparable{

    public String name,surName,email,userName,mobile,password,specialty,contract;
    public int daysWorked;
    public UserData() {

    }

    public UserData(String name, String surName, String email, String userName, String mobile, String password, String specialty, String contract,Integer daysWorked) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.specialty = specialty;
        this.contract = contract;
        this.daysWorked = daysWorked;
    }

    @Override
    public int compareTo(Object o) {
        UserData u = (UserData)o;
        if(this.daysWorked > u.daysWorked)
        return -1;
        else
            return 1;
    }
}
