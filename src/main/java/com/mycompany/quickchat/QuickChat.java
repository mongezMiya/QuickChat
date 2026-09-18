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

        System.out.println("Hi there! Please enter your first name:");
        String firstName = input.nextLine();

        System.out.println("Wonderful! Now please enter your last name:");
        String lastName = input.nextLine();

        System.out.println("Please enter your username:");
        String userName = input.nextLine();

        System.out.println("Please enter your phone number:");
        String phonenumber = input.nextLine();

        System.out.println("Please enter your password:");
        String password = input.nextLine();

        Login user = new Login(firstName, lastName, userName,
                phonenumber, password);

        String registrationMessage = user.registerUser();

        System.out.println(registrationMessage);

        System.out.println("\n======= LOGIN =======");

        System.out.println("Please enter your username:");
        String loginUsername = input.nextLine();

        System.out.println("Please enter your password:");
        String loginPassword = input.nextLine();

        boolean loginSuccessful = user.loginUser(
                loginUsername, loginPassword);

        System.out.println(user.returnLoginStatus(loginSuccessful));

        input.close();
    }
}