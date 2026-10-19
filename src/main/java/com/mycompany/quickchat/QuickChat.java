package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ---------- PART 1: REGISTRATION ----------
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

        boolean registered = user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber();

        if (registered) {

            // ---------- PART 1: LOGIN ----------
            System.out.println("\n======= LOGIN =======");

            System.out.println("Please enter your username:");
            String loginUsername = input.nextLine();

            System.out.println("Please enter your password:");
            String loginPassword = input.nextLine();

            boolean loginSuccessful = user.loginUser(
                    loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(loginSuccessful));

            // ---------- PART 2: MESSAGING ----------
            // Only users who logged in successfully may send messages
            if (loginSuccessful) {

                System.out.println("\nWelcome to QuickChat.");

                System.out.print("How many messages do you wish to enter? ");
                int maxMessages = Integer.parseInt(input.nextLine());

                boolean messagesEntered = false;
                boolean running = true;

                while (running) {
                    System.out.println("\n1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");

                    int option = Integer.parseInt(input.nextLine());

                    if (option == 1) {

                        if (messagesEntered) {
                            System.out.println("You have already entered all "
                                    + maxMessages + " messages.");
                        } else {

                            // message number comes from the loop counter
                            for (int i = 0; i < maxMessages; i++) {
                                System.out.println("\nMessage " + (i + 1)
                                        + " of " + maxMessages);
                                System.out.println("----------------------------");

                                System.out.print("Recipient cell number: ");
                                String recipient = input.nextLine();
                                String recipientResult
                                        = Message.checkRecipientCell(recipient);
                                while (!recipientResult.equals(
                                        "Cell phone number successfully captured.")) {
                                    System.out.println(recipientResult);
                                    System.out.print("Recipient cell number: ");
                                    recipient = input.nextLine();
                                    recipientResult
                                            = Message.checkRecipientCell(recipient);
                                }
                                System.out.println(recipientResult);

                                System.out.print("Message: ");
                                String text = input.nextLine();
                                String lengthResult
                                        = Message.checkMessageLength(text);
                                while (!lengthResult.equals(
                                        "Message ready to send.")) {
                                    System.out.println("Please enter a message of less than 250 characters.");
                                    System.out.println(lengthResult);
                                    System.out.print("Message: ");
                                    text = input.nextLine();
                                    lengthResult = Message.checkMessageLength(text);
                                }
                                System.out.println(lengthResult);

                                String messageId = Message.generateMessageID();
                                Message message = new Message(messageId, i,
                                        recipient, text);

                                System.out.println("Message ID generated: "
                                        + message.getMessageID());

                                System.out.println("1) Send Message");
                                System.out.println("2) Disregard Message");
                                System.out.println("3) Store Message to send later");
                                int choice = Integer.parseInt(input.nextLine());
                                System.out.println(message.SentMessage(choice));

                                if (choice == 1) {
                                    System.out.println(message.getDetails());
                                }
                            }

                            messagesEntered = true;

                            System.out.println("\nTotal messages sent: "
                                    + Message.returnTotalMessages());
                        }

                    } else if (option == 2) {
                        System.out.println("Coming Soon.");
                    } else if (option == 3) {
                        running = false;
                    } else {
                        System.out.println("Please choose 1, 2 or 3");
                    }
                }

                System.out.println("Goodbye!");
            }

        } else {
            System.out.println("Registration unsuccessful. Goodbye.");
        }

        input.close();
    }
}