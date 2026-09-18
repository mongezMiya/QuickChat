/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class QuickChatIT {
    
    public QuickChatIT() {
    }
    
   

    /**
     * Test of main method, of class QuickChat.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        QuickChat.main(args);
        
    }

    /**
     * Test of checkAge method, of class QuickChat.
     */
    @Test
    public void testCheckAge() {
        System.out.println("checkAge");
        int age = 0;
        QuickChat instance = null;
        boolean expResult = false;
        boolean result = instance.checkAge(age);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkMemberNumber method, of class QuickChat.
     */
    @Test
    public void testCheckMemberNumber() {
        System.out.println("checkMemberNumber");
        String number = "";
        QuickChat instance = null;
        boolean expResult = false;
        boolean result = instance.checkMemberNumber(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registerMember method, of class QuickChat.
     */
    @Test
    public void testRegisterMember() {
        System.out.println("registerMember");
        String memberName = "";
        int memberAge = 0;
        String memberNumber = "";
        QuickChat instance = null;
        String expResult = "";
        String result = instance.registerMember(memberName, memberAge, memberNumber);
        assertEquals(expResult, result);
        
    }
    
}
