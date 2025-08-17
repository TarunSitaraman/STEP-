import java.util.Scanner;

public class charfrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256]; // ASCII size

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char)i + ": " + freq[i]);
            }
        }
    }
}
