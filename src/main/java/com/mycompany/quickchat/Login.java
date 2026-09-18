package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class Login {

    public String firstName;
    public String lastName;
    public String userName;
    public String phonenumber;
    public String password;

    // Constructor
    public Login(String firstName, String lastName, String userName,
            String phonenumber, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    // Checks if the username is correctly formatted
    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    // Checks if the password is correctly formatted
    public boolean checkPasswordComplexity() {

        boolean hasLength = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        return hasLength && hasCapital && hasNumber && hasSpecial;
    }

    // Checks if the cellphone number is correctly formatted
    public boolean checkCellPhoneNumber() {
        return phonenumber.matches("^\\+27[0-9]{9}$");
    }

    // Registers the user
    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Username successfully captured.";
    }

    // Checks the login details
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return userName.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    // Returns the login status
    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

    
