
import java.util.Stack;

public class InfixToPostfix {

    // Method to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^': // exponent operator, highest precedence
                return 3;
        }
        return -1;
    }

    public static String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            // If character is an operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            } // If ')', pop and append to output until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            } else {
                // Operator found
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the remaining operators from stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix1 = "A+B*C";
        String infix2 = "(A+B)*C";
        System.out.println("Infix: " + infix1 + " -> Postfix: " + toPostfix(infix1)); // ABC*+
        System.out.println("Infix: " + infix2 + " -> Postfix: " + toPostfix(infix2)); // AB+C*
    }
}
