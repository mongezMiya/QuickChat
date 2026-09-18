/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Student
 */
public class NewClassIT {
    
    public NewClassIT() {
    }

    /**
     * Test of checkPassword method, of class NewClass.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        NewClass instance = new NewClass();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkphonenumber method, of class NewClass.
     */
    @Test
    public void testCheckphonenumber() {
        System.out.println("checkphonenumber");
        String phonenumber = "";
        NewClass instance = new NewClass();
        boolean expResult = false;
        boolean result = instance.checkphonenumber(phonenumber);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkuserName method, of class NewClass.
     */
    @Test
    public void testCheckuserName() {
        System.out.println("checkuserName");
        String number = "";
        NewClass instance = new NewClass();
        boolean expResult = false;
        boolean result = instance.checkuserName(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of RegisterUser method, of class NewClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        String userName = "";
        String Password = "";
        String phoneNumber = "";
        NewClass instance = new NewClass();
        String expResult = "";
        String result = instance.RegisterUser(userName, Password, phoneNumber);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of UserLogin method, of class NewClass.
     */
    @Test
    public void testUserLogin() {
        System.out.println("UserLogin");
        String userName = "";
        String Password = "";
        String phonenumber = "";
        NewClass instance = new NewClass();
        boolean expResult = false;
        boolean result = instance.UserLogin(userName, Password, phonenumber);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of userLoginStatus method, of class NewClass.
     */
    @Test
    public void testUserLoginStatus() {
        System.out.println("userLoginStatus");
        boolean loginSuccessful = false;
        boolean loginUnsuccessful = false;
        NewClass instance = new NewClass();
        String expResult = "";
        String result = instance.userLoginStatus(loginSuccessful, loginUnsuccessful);
        assertEquals(expResult, result);
        
    }
    
}
