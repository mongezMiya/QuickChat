/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class QuickChat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("======= REGISTRATION =======");
        
        //first name
        System.out.print("Hi there, please enter your username: ");
        String userNumber = input.nextLine();
        
        System.out.print("Hi there, please enter your phonenumber: ");
        String phonenumber = input.nextLine();
        
        System.out.print("Hi there, please enter your password: ");
        String password = input.nextLine();
        String userName = null;
        
        //registration captures the user's details
        NewClass NewClass = new NewClass(
                userName,
                phonenumber,
                password
                
        );
        
        //Login verifies user details
           
    }
}
