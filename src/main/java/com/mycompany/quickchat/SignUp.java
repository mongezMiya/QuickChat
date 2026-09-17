
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class SignUp {
    
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String password;
    
    public SignUp(String firstName, String lastName, String userName, String phoneNumber, String password){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    SignUp(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getfirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
        
    public String getuserName(){
        return userName;
    }
    public String getphoneNumber(){
        return phoneNumber;
    }
    public String getpassword(){
        return password;
}
}
