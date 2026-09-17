/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class NewClassTest {
    
    public NewClassTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
