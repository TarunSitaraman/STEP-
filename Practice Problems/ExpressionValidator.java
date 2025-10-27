import java.util.*;

public class ExpressionValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean balanced = true;

        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    balanced = false;
                    break;
                }
            }
        }

        if (balanced && stack.isEmpty()) {
            System.out.println("Expression is Balanced");
        } else {
            System.out.println("Expression is Not Balanced");
        }
    }
}
