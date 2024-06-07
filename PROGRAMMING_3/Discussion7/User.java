package PROGRAMMING_3.Discussion7;

public class User {
    // Private field to store the password
    private String password;

    // Constructor to set the password
    public User(String password) {
        this.password = password;
    }

    // Public method to validate the password
    public boolean validatePassword(String inputPassword) {
        return checkPassword(inputPassword);
    }

    // Public method to change the password with validation
    public boolean changePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    // Private method to check the password
    private boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
