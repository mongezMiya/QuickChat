package com.mycompany.quickchat;

import java.util.Random;

/**
 * Represents one chat message and tracks all messages sent while the
 * program is running.
 *
 * @author Student
 */
public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Shared by all messages, hence they are static
    private static int totalSent = 0;
    private static String sentReport = "";
    private static String storedReport = "";

    // Constructor that runs every time a new message is created
    public Message(String messageID, int messageNumber, String recipient,
            String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // Makes a random 10 digit number from 2 five-digit halves
    public static String generateMessageID() {
        Random rand = new Random();
        int firstHalf = rand.nextInt(90000) + 10000;
        int secondHalf = rand.nextInt(90000) + 10000;

        return "" + firstHalf + secondHalf;
    }

    // Message ID must be no more than ten characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Recipient must have the international code followed by the number
    // (same regex as Part 1)
    public static String checkRecipientCell(String cell) {
        if (cell.matches("^\\+27[0-9]{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not "
                    + "contain an international code. Please correct the "
                    + "number and try again.";
        }
    }

    // Message must not be more than 250 characters
    public static String checkMessageLength(String text) {
        if (text.length() <= 250) {
            return "Message ready to send.";
        } else {
            int over = text.length() - 250;
            return "Message exceeds 250 characters by " + over
                    + "; please reduce the size.";
        }
    }

    // Hash = first two digits of ID : message number : FIRSTLAST (CAPITALS)
    // e.g. ID 0012345678, message 0, "Hi Mike, can you join us for dinner
    // tonight?" -> 00:0:HITONIGHT
    public String createMessageHash() {
        String text = messageText.trim();

        // first two digits of the ID
        String firstTwo = messageID.substring(0, 2);

        // first word - from where it starts to where there is a space
        String firstWord;
        int firstSpace = text.indexOf(" ");
        if (firstSpace == -1) {
            firstWord = text;
        } else {
            firstWord = text.substring(0, firstSpace);
        }

        // last word - from after the last space to the end
        int lastSpace = text.lastIndexOf(" ");
        String lastWord = text.substring(lastSpace + 1);

        firstWord = removeEndPunctuation(firstWord);
        lastWord = removeEndPunctuation(lastWord);

        String hash = firstTwo + ":" + messageNumber + ":" + firstWord
                + lastWord;
        return hash.toUpperCase();
    }

    // Removes punctuation at the end of a word, e.g. "tonight?" -> "tonight"
    private String removeEndPunctuation(String word) {
        while (word.length() > 0 && isPunctuation(
                word.substring(word.length() - 1))) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

    private boolean isPunctuation(String character) {
        return character.equals("?") || character.equals(".")
                || character.equals(",") || character.equals("!");
    }

    // 1 - send, 2 - disregard, 3 - store to send later
    public String SentMessage(int choice) {
        if (choice == 1) {
            totalSent = totalSent + 1;
            sentReport = sentReport + getDetails() + "\n-----------\n";
            return "Message successfully sent.";

        } else if (choice == 2) {
            return "Press 0 to delete the message.";

        } else if (choice == 3) {
            storedReport = storedReport + getDetails() + "\n-----------\n";
            return "Message successfully stored.";

        } else {
            return "Invalid option.";
        }
    }

    // Details in the required order: ID, Hash, Recipient, Message
    public String getDetails() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    // Returns all the messages sent while the program is running
    public static String printMessages() {
        if (sentReport.equals("")) {
            return "No messages sent yet";
        } else {
            return sentReport;
        }
    }

    public static int returnTotalMessages() {
        return totalSent;
    }

    // Clears the shared totals (used by the unit tests)
    public static void resetTotals() {
        totalSent = 0;
        sentReport = "";
        storedReport = "";
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }
}