package com.mycompany.quickchat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Message class (Part 2).
 *
 * @author Student
 */
public class MessageIT {

    // Test data from the brief
    private final String recipient1 = "+27718693002";
    private final String text1 = "Hi Mike, can you join us for dinner tonight?";

    private final String recipient2 = "08575975889";
    private final String text2 = "Hi Keegan, did you receive the payment?";

    // A fixed ID so the hash is predictable (generated IDs are random)
    private final String fixedId = "0012345678";

    // The totals are static, so clear them before every test
    @BeforeEach
    public void setUp() {
        Message.resetTotals();
    }

    // ---------- Message length ----------

    @Test
    public void testMessageLengthSuccess() {
        assertEquals("Message ready to send.",
                Message.checkMessageLength(text1));
    }

    @Test
    public void testMessageLengthExactly250IsAccepted() {
        String exact = "";
        for (int i = 0; i < 250; i++) {
            exact = exact + "a";
        }
        assertEquals("Message ready to send.",
                Message.checkMessageLength(exact));
    }

    @Test
    public void testMessageLengthFailure() {
        String tooLong = "";
        for (int i = 0; i < 260; i++) {
            tooLong = tooLong + "a";
        }
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.",
                Message.checkMessageLength(tooLong));
    }

    // ---------- Recipient cell number ----------

    @Test
    public void testRecipientCellSuccess() {
        assertEquals("Cell phone number successfully captured.",
                Message.checkRecipientCell(recipient1));
    }

    @Test
    public void testRecipientCellFailure() {
        assertEquals("Cell phone number is incorrectly formatted or does not "
                + "contain an international code. Please correct the number "
                + "and try again.",
                Message.checkRecipientCell(recipient2));
    }

    // ---------- Message hash ----------

    @Test
    public void testMessageHashTestCase1() {
        Message message = new Message(fixedId, 0, recipient1, text1);
        assertEquals("00:0:HITONIGHT", message.getMessageHash());
    }

    // Tests the hashes of both test messages in a loop
    @Test
    public void testMessageHashesInLoop() {
        for (int i = 0; i < 2; i++) {
            String text;
            String expectedHash;

            if (i == 0) {
                text = text1;
                expectedHash = "00:0:HITONIGHT";
            } else {
                text = text2;
                expectedHash = "00:1:HIPAYMENT";
            }

            Message message = new Message(fixedId, i, recipient1, text);
            assertEquals(expectedHash, message.createMessageHash());
        }
    }

    // ---------- Message ID ----------

    @Test
    public void testMessageIDIsCreated() {
        String id = Message.generateMessageID();
        assertEquals(10, id.length());
        assertTrue(id.matches("[0-9]+"));

        Message message = new Message(id, 0, recipient1, text1);
        assertTrue(message.checkMessageID());
        assertEquals("Message ID generated: " + id,
                "Message ID generated: " + message.getMessageID());
    }

    @Test
    public void testMessageIDTooLongFails() {
        Message message = new Message("12345678901", 0, recipient1, text1);
        assertFalse(message.checkMessageID());
    }

    // ---------- Send / Disregard / Store ----------

    @Test
    public void testSendMessage() {
        Message message = new Message(fixedId, 0, recipient1, text1);
        assertEquals("Message successfully sent.", message.SentMessage(1));
    }

    @Test
    public void testDisregardMessage() {
        Message message = new Message(fixedId, 1, recipient2, text2);
        assertEquals("Press 0 to delete the message.", message.SentMessage(2));
    }

    @Test
    public void testStoreMessage() {
        Message message = new Message(fixedId, 1, recipient2, text2);
        assertEquals("Message successfully stored.", message.SentMessage(3));
    }

    // ---------- Totals and printing ----------

    @Test
    public void testTotalMessagesSent() {
        Message message1 = new Message(fixedId, 0, recipient1, text1);
        Message message2 = new Message(fixedId, 1, recipient2, text2);

        message1.SentMessage(1);   // sent
        message2.SentMessage(2);   // disregarded, so not counted

        assertEquals(1, Message.returnTotalMessages());
    }

    @Test
    public void testPrintMessagesShowsSentMessage() {
        Message message1 = new Message(fixedId, 0, recipient1, text1);
        message1.SentMessage(1);

        String printed = Message.printMessages();
        assertTrue(printed.contains("Message Hash: 00:0:HITONIGHT"));
        assertTrue(printed.contains("Recipient: +27718693002"));
        assertTrue(printed.contains(text1));
    }

    @Test
    public void testPrintMessagesWhenNothingSent() {
        assertEquals("No messages sent yet", Message.printMessages());
    }
}