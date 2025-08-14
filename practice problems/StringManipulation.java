import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting: ");
        String sentence = sc.nextLine();

        // 1. trim() - Remove extra spaces
        String trimmed = sentence.trim();
        System.out.println("Trimmed: " + trimmed);

        // 2. replace() - Replace all spaces with underscores
        String underscores = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced with underscores: " + underscores);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = underscores.replaceAll("\\d", "");
        System.out.println("Digits removed: " + noDigits);

        // 4. split() - Split sentence into words array
        String[] words = noDigits.split("_");
        System.out.println("Words array: ");
        for (String word : words) {
            System.out.println(word);
        }

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("Joined words: " + joined);

        // Remove all punctuation
        

        // Capitalize first letter of each word

        // Reverse the order of words

        // Count word frequency
        
    }
}
