import java.util.HashMap;
import java.util.Scanner;

public class charfrequency_unique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') { // Ignore spaces
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Character frequencies (unique characters):");
        for (char ch : freqMap.keySet()) {
            System.out.println(ch + ": " + freqMap.get(ch));
        }
    }
}