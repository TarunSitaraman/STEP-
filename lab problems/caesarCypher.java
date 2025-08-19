import java.util.Scanner;

public class caesarCypher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("This is a caesar cypher. Enter a string to encrypt:");
        String input = scanner.nextLine();
        StringBuilder cipher = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + 3) % 26 + base);
                cipher.append(shifted);
            } else {
                cipher.append(ch);
            }
        }
        System.out.println(cipher);
    }
}
