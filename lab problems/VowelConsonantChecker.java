import java.util.Scanner;

public class VowelConsonantChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch)) System.out.println(ch + ": Not a Letter");
            else if ("aeiouAEIOU".indexOf(ch) != -1) System.out.println(ch + ": Vowel");
            else System.out.println(ch + ": Consonant");
        }
    }
}
