package DATA_STRUCTURES_AND_ALGORITHMS.CTA4;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static String convertToPostfix(String infix) {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char nextCharacter = infix.charAt(i);

            switch (nextCharacter) {
                default:
                    if (Character.isLetterOrDigit(nextCharacter)) {
                        postfix.append(nextCharacter);
                    }
                    break;
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty() && precedence(nextCharacter) <= precedence(operatorStack.peek())) {
                        postfix.append(operatorStack.pop());
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    char topOperator = operatorStack.pop();
                    while (topOperator != '(') {
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
            }
        }

        while (!operatorStack.isEmpty()) {
            char topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }

        return postfix.toString();
    }

    private static int precedence(char character) {
        switch (character) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter an infix expression:");
        String infixExpression = scanner.nextLine();

        String postfixExpression = convertToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        scanner.close();
    }
}

