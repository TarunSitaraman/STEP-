import java.util.Scanner;

public class caseConvert {
    // Convert string to uppercase using ASCII values
    public static String toUpperCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Convert string to lowercase using ASCII values
    public static String toLowerCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Convert string to title case using ASCII values
    public static String toTitleCase(String input) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                result.append(ch);
                newWord = true;
            } else if (newWord && ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));// Convert first letter of the word to uppercase
                newWord = false;
            } else if (!newWord && ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));// Convert subsequent letters to lowercase
            } else {
                result.append(ch);
                newWord = false;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        System.out.println("Choose conversion:");
        System.out.println("1. Uppercase");
        System.out.println("2. Lowercase");
        System.out.println("3. Title Case");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        String converted;
        switch (choice) {
            case 1:
                converted = toUpperCase(text);
                break;
            case 2:
                converted = toLowerCase(text);
                break;
            case 3:
                converted = toTitleCase(text);
                break;
            default:
                converted = "Invalid choice!";
        }

        System.out.println("Converted text:");
        System.out.println(converted);
    }
}