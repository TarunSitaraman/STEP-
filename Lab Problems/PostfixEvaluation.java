import java.util.Stack;

public class PostfixEvaluation {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                // If token is an operand, push it onto the stack
                stack.push(Integer.parseInt(token));
            } else {
                // Token is an operator, pop two operands
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                
                switch(token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
                // Push the result back on the stack
                stack.push(result);
            }
        }
        // The result is the last element in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "6 3 2 + *";
        System.out.println("Input: " + expr + " → Output: " + evaluatePostfix(expr));
    }
}
