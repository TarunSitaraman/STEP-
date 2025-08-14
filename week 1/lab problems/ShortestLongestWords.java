import java.util.Scanner;

public class ShortestLongestWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = scanner.nextLine();
        String[] words = text.split("\\W+");
        if (words.length == 0) {
            System.out.println("No words found in the input.");
            return;
        }
        String shortest = words[0];
        String longest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Shortest word: " + shortest);
        System.out.println("Longest word: " + longest);
    }
}
