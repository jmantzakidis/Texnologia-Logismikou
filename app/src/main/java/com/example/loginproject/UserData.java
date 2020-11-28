package com.example.loginproject;

/**
 * A class that defines UserData
 */
public class UserData {

    public String name,surName,email,userName,mobile,password,specialty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
