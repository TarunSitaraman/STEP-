import java.util.Scanner;

public class nonrepeatingcharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Character result = firstNonRepeatingChar(input);
        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static Character firstNonRepeatingChar(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < n; j++) {
                if (i != j && str.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return c;
            }
        }
        return null;
    }
}
