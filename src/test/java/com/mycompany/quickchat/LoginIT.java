
package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginIT {

    @Test
    public void testCheckUserName() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertTrue(instance.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertTrue(instance.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertTrue(instance.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUser() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertEquals(
                "Username successfully captured.",
                instance.registerUser()
        );
    }

    @Test
    public void testLoginUser() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertTrue(instance.loginUser("ab_c", "Password1!"));
        assertFalse(instance.loginUser("wrong", "Password1!"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login instance = new Login(
                "John", "Smith", "ab_c", "+27123456789", "Password1!"
        );

        assertEquals(
                "Welcome John, Smith it is great to see you again.",
                instance.returnLoginStatus(true)
        );

        assertEquals(
                "Username or password incorrect, please try again.",
                instance.returnLoginStatus(false)
        );
    }
}
