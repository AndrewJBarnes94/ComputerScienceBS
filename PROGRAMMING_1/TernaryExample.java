public class TernaryExample {

    public static String getUsername(User user) {
        return (user != null) ? user.getName() : "Guest";   // <--- Ternary Operator Example Here
    }

    public static void main(String[] args) {
        // Test the getUsername method
        User existingUser = new User("John");
        User nullUser = null;

        System.out.println("Username is: " + getUsername(existingUser));  // Output: "Username is: John"
        System.out.println("Username is: " + getUsername(nullUser));  // Output: "Username is: Guest"
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
