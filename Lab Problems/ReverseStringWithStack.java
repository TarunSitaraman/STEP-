import java.util.Stack;

public class ReverseStringWithStack {
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        // Push all characters of the string into the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        // Pop characters to construct the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "HELLO";
        System.out.println("Input: " + str + " → Output: " + reverse(str));
    }
}
