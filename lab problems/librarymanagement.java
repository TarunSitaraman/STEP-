import java.util.Scanner;

class librarymanagement{
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;
    int totalBooks;
    int availableBooks;
    public void issueBook(){
        if(isAvailable){
            isAvailable = false;
            availableBooks--;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }
    public void returnBook(){
        if(!isAvailable){
            isAvailable = true;
            availableBooks++;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not issued.");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System");
        System.out.println("1. Issue Book");
        System.out.println("2. Return Book");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
    }
}