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
    
        public String userName;
        public String phonenumber;
        public String password;
    
    public NewClass (String userName, String phonenumber, String password){
        this.userName = userName;
        this.phonenumber = phonenumber;
        this.password = password;
}

    NewClass() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public boolean checkPassword(String password){
        if (password.contains("A-Z" + "0-9" + "^-zA-z0-9") && password.length() ==8){
            return true;
        }else {
            return false;
            
        
        }
    }
    
    public boolean checkphonenumber(String phonenumber){
        if (phonenumber.startsWith("+27") && phonenumber.length()==11){
            return true;
        }else{
            return false;
        
        }
    }
    
    public boolean checkuserName(String number){
        if (userName.contains("_") && userName.length()==12){
            return true;
        }else{
            return false;
        
        }
    }
    
    public String RegisterUser(String userName, String Password, String phoneNumber){
        if (!checkuserName (userName)){
            return "Username format is incorrect; ensure that useername contains an underscore and is not more than 12 characters";
        }else if (!checkPassword(password)){
            return "Password format is incorrect; ensure that password contains at least 8 characters, a capital letter, a number";
        }else if (!checkphonenumber(phonenumber)){
            return "Cellphone number format is incorrect; initialize with international code";
        }else{
            return "Login successful, welcome <user first name>, <user last name> it is great to see you";
        }
    }
    
    public boolean UserLogin(String userName, String Password, String phonenumber){
        //if (Username.equals(userName))
        //if (password.equals(password))
        return this.userName.equals(userName) && this.password.equals(Password);
    }
    
    public String userLoginStatus(boolean loginSuccessful, boolean loginUnsuccessful){
        if(!checkPassword(password)){
            return "welcome <user first name>, <user last name>.";
        }
        if(!checkphonenumber(phonenumber)){
            return "incorrect username or password, please try again.";
        }
        if(!checkuserName(userName)){
        return "Login unsuccessful.";
        
        }
            return null;
    
        }
    
}


