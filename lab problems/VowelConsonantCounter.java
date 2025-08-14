import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        int vowelCount=0;
        int consonantCount=0;
        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch)) System.out.println(ch + ": Not a Letter");
            else if("aeiouAEIOU".indexOf(ch) != -1){
                vowelCount++;
            }
            else{
                consonantCount++;
            }
        }
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonant: " + consonantCount);
    }
}
