import java.util.Scanner;

public class calculator {
    public static int evaluate(String expr) {
        int result = 0, num = 0;
        char sign = '+';
        expr = expr.replaceAll(" ", "");
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == expr.length() - 1) {
                if (sign == '+') result += num;
                else if (sign == '-') result -= num;
                else if (sign == '*') result *= num;
                else if (sign == '/') result /= num;
                sign = c;
                num = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(evaluate(input));
    }
}
