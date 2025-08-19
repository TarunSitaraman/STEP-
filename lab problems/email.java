import java.util.Scanner;

class email {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email address: ");
        String email = sc.nextLine();
        String[] parts = email.split("@");
        if (parts.length != 2) {
            System.out.println("Invalid email address");
        } else {
            String username = parts[0];
            String domain = parts[1];
            if (username.length() < 3 || username.length() > 20) {
                System.out.println("Invalid username length");
            } else if (!domain.contains(".")) {
                System.out.println("Domain must contain a dot");
            } else {
                String[] domainParts = domain.split("\\.");
                if (domainParts.length < 2 || domainParts[0].length() < 2 || domainParts[1].length() < 2) {
                    System.out.println("Invalid domain format");
                } else {
                    System.out.println("Valid email address");  
                }
            }
        }
        //extract username and domain using substring()
        String username = email.substring(0, email.indexOf('@'));
        String domain = email.substring(email.indexOf('@') + 1);
        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);
    }    
}
