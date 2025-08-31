import java.util.Scanner;

public class datacompression {
    public static String compress(String input) {
        int[] freq = new int[256];
        for (char c : input.toCharArray()) {
            freq[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(freq[c]).append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(compress(input));
    }
}
