public class uniquecharacters {
    public static void main(String[] args) {
        String input = "programming";
        String unique = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (unique.indexOf(ch) == -1) {
                unique += ch;
            }
        }

        System.out.println("Unique characters: " + unique);
    }
}
