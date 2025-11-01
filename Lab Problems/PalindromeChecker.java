
import java.util.Stack;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();

        // Push characters into stack
        for (char ch : cleanedStr.toCharArray()) {
            stack.push(ch);
        }

        // Form the reversed string by popping from stack
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Compare original cleaned string with reversed
        return cleanedStr.equals(reversed.toString());
    }

    public static void main(String[] args) {
        String input1 = "Madam";
        String input2 = "OpenAI";

        System.out.println("\"" + input1 + "\" is " + (isPalindrome(input1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("\"" + input2 + "\" is " + (isPalindrome(input2) ? "Palindrome" : "Not Palindrome"));
    }
}
