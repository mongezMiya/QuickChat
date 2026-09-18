/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class NewClass {

    public String firstName;
    public String lastName;
    public String userName;
    public String phonenumber;
    public String password;

    public NewClass(String firstName, String lastName, String userName,
            String phonenumber, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    NewClass() {

    }

    public boolean checkPassword(String password) {
        if (password.matches("^(?=.*[A-Z])(?=.*[0-9]).{8}$")) {
            return true;
        }
        return false;
    }

    public boolean checkphonenumber(String phonenumber) {
        if (phonenumber.startsWith("+27") && phonenumber.length() == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkuserName(String userName) {
        return userName.contains("_") && userName.length() <= 12;
    }

    public String RegisterUser(String userName, String Password, String phoneNumber) {

        if (!checkuserName(userName)) {
            return "Username format is incorrect; ensure that username contains an underscore and is not more than 12 characters";

        } else if (!checkPassword(Password)) {
            return "Password format is incorrect; ensure that password contains at least 8 characters, a capital letter, a number";

        } else if (!checkphonenumber(phoneNumber)) {
            return "Cellphone number format is incorrect; initialize with international code";

        } else {
            return "Registration successful, welcome " + firstName + " "
                    + lastName + ", it is great to see you";
        }
    }

    public boolean UserLogin(String userName, String Password, String phonenumber) {

        return this.userName.equals(userName)
                && this.password.equals(Password)
                && this.phonenumber.equals(phonenumber);
    }

    public String userLoginStatus(boolean loginSuccessful, boolean loginUnsuccessful) {
    if (loginSuccessful) {
        return "Welcome " + firstName + " " + lastName + ".";
    } else {
        return "Incorrect username or password, please try again.";
    }
}

}


    


         



