import java.util.*;

class TextProcessor {

    // Method to clean and validate input
    public static String cleanInput(String input) {
        // Remove extra spaces and convert to lower case
        return input.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    // Method to analyze text
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Find most common character
        int[] freq = new int[256];
        for (char c : text.replace(" ", "").toCharArray()) {
            freq[c]++;
        }
        char mostCommon = ' ';
        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
            maxFreq = freq[i];
            mostCommon = (char) i;
            }
        }

        System.out.println("Word count: " + wordCount);
        System.out.println("Character count: " + charCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: " + mostCommon);
    }

    // Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("Words in alphabetical order:");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("Search for a word: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(search);
        if (found) {
            System.out.println("Word found!");
        } else {
            System.out.println("Word not found.");
        }
    }
}