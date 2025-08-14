public class StringBuiltinMethods {
    public static void main(String[] args) {
        String text = "  Java programming is fun and challenging!  ";

    // 1. Display original string length including spaces
    System.out.println("Original length (including spaces): " + text.length());

    // 2. Remove leading and trailing spaces, show new length
    String trimmed = text.trim();
    System.out.println("Trimmed length: " + trimmed.length());

    // 3. Find and display the character at index 5
    System.out.println("Character at index 5: " + text.charAt(5));

    // 4. Extract substring "Programming" from the text
    int start = text.indexOf("programming");
    int end = start + "programming".length();
    String substring = text.substring(start, end);
    System.out.println("Extracted substring: " + substring);
    }

    //Method to count vowels in a string
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        System.out.print("Positions of '" + target + "': ");
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
}