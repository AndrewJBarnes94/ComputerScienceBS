package DATA_STRUCTURES_AND_ALGORITHMS.Discussion4;

import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
        String input = "Andrew Barnes";
        String reverseInput = reverseStringWithStack(input);
        System.out.println("OUTPUT: " + reverseInput);
    }
    
    private static String reverseStringWithStack(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        StringBuilder reversedString = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }
}
