import java.util.Scanner;
public class passwordanalyser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        int length = pass.length();
        int passwordScore = 0;
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (int i = 0; i < length; i++) {
            char ch = pass.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            } else if (Character.isDigit(ch)) {
                digit++;
            } else {
                special++;
            }
        }
        if(length>8){
            int extra = length - 8;
            passwordScore = extra *2;
        }
        if(upper>0 && lower>0 && digit>0 && special>0){
            passwordScore += 40;
        } else if((upper>0 && lower>0 && digit>0) || (upper>0 && lower>0 && special>0) || (upper>0 && digit>0 && special>0) || (lower>0 && digit>0 && special>0)){
            passwordScore += 30;
        } else if(upper>0 || lower>0 || digit>0 || special>0){
            passwordScore += 10;
        }
        if(pass == "qwerty" || pass == "123456" || pass == "password" || pass == "abc123" || pass == "letmein"){
            passwordScore -= 30;
        }
    }
    System.out.print("Password Score: " + passwordScore);
    if(passwordScore < 20){
        System.out.println(" - Weak Password");
    } else if(passwordScore < 40){
        System.out.println(" - Moderate Password");
    } else {
        System.out.println(" - Strong Password");
    }
}
