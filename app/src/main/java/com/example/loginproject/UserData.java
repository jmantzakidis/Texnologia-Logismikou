package com.example.loginproject;

/**
 * A class that defines UserData
 */
public class UserData {

    public String name,surName,email,userName,mobile,password,specialty;

    public UserData() {

    }

    /**
     * We Store the User Data
     * @param name
     * @param surName
     * @param email
     * @param userName
     * @param mobile
     * @param password
     * @param specialty
     */
    public UserData(String name, String surName, String email, String userName, String mobile, String password, String specialty) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.specialty = specialty;
    }

}
