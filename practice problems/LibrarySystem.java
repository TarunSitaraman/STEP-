import java.util.Scanner;
public class Book{
    String title, author, isbn;
    double price;
    int quantity;
    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
    public double getTotalValue() {
        return price * quantity;
    }   
}    

public class Libary{
    String libraryName;
    Book[] books;
    int totalBooks;
    public Libary(String libraryName, int capacity) {
        this.libraryName = libraryName;
        this.books = new Book[capacity];
        this.totalBooks = 0;
    }
    public void addBook(Book book) {
        if (totalBooks < books.length) {
            books[totalBooks++] = book;
            System.out.println("Added book: " + book.title);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }
    public Book searchBookByTitle(String title) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    public Book searchBookByAuthor(String author) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].author.equalsIgnoreCase(author)) {
                return books[i];
            }
        }
        return null;
    }
    public void displayInventory() {
        System.out.println("Library: " + libraryName);
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBookInfo();
            System.out.println();
        }
    }

}
public class LibrarySystem {
    Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 10.99, 5);
    Book book2 = new Book("1984", "George Orwell", "9780451524935", 8.99, 3);
    Libary library = new Libary("City Library", 100);
    book1.addBook("Walden", "Henry David Thoreau", "9780143038412", 12.99, 4);
    library.searchBookByAuthor("George Orwell");
    library.displayInventory();
    library.getTotalValue();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Library System");
        System.out.println("------------------------------");
        System.out.println("Library Name: " + library.libraryName);
        System.out.println();
        System.out.println("Select Option");
        System.out.println("1. Add Book\n2. Search Book\n3. Display All Books\n4. Calculate Total Value\n5. Exit");
        int choice = sc.nextInt();
        if(choice ==1){
            System.out.println("Enter Book Title:");
            String title = sc.next();
            System.out.println("Enter Book Author:");
            String author = sc.next();
            System.out.println("Enter Book ISBN:");
            String isbn = sc.next();
            System.out.println("Enter Book Price:");
            double price = sc.nextDouble();
            System.out.println("Enter Book Quantity:");
            int quantity = sc.nextInt();
            Book newBook = new Book(title, author, isbn, price, quantity);
            library.addBook(newBook);
        } else if(choice ==2){
            System.out.println("Search by:\n1. Title\n2. Author");
            int searchChoice = sc.nextInt();
            if(searchChoice ==1){   
                System.out.println("Enter Book Title:");
                String title = sc.next();
                Book foundBook = library.searchBookByTitle(title);
                if(foundBook != null){
                    foundBook.displayBookInfo();
                } else {
                    System.out.println("Book not found.");
                }
            } else if(searchChoice ==2){   
                System.out.println("Enter Book Author:");
                String author = sc.next();
                Book foundBook = library.searchBookByAuthor(author);
                if(foundBook != null){
                    foundBook.displayBookInfo();
                } else {
                    System.out.println("Book not found.");
                }
            }  
        }
    }
}