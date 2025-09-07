public class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // Default constructor
    public Book() {
        this("", "", "", true);
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "", true);
    }

    // Constructor with all details
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = available;
    }

    // Borrow book
    public void borrowBook() {
        isAvailable = false;
    }

    // Return book
    public void returnBook() {
        isAvailable = true;
    }

    // Display book info
    public void displayBookInfo() {
        System.out.println("Title: " + title +
            ", Author: " + author +
            ", ISBN: " + isbn +
            ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", "123456", true);

        b2.borrowBook();
        b3.borrowBook();
        b3.returnBook();

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
