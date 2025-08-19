import java.util.Scanner;

public class replaceString {
    public static String findAndReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int len = find.length();

        while (i <= text.length() - len) {
            if (text.substring(i, i + len).equals(find)) {
                result.append(replace);
                i += len;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        result.append(text.substring(i));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter the substring to replace with: ");
        String replace = sc.nextLine();

        String replacedText = findAndReplace(text, find, replace);
        System.out.println("Result: " + replacedText);
    }
}