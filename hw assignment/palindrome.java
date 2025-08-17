import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        boolean isPalindrome = true;
        int n = text.length();
        for (int i = 0; i < n / 2; i++) {
            if (text.charAt(i) != text.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
        sc.close();
    }
}
