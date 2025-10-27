import java.util.*;

// Book class
public class Book {
    private String title;
    private String author;
    private String isbn;

    // Parameterized constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Show details of the book
    public void showDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }

    // Getter for title
    public String getTitle() {
        return title;
    }
}

// Library class
class Library {
    private String name;
    private List<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book '" + book.getTitle() + "' to " + name + " Library");
    }

    // Show all books in the library
    public void showBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            book.showDetails();
        }
    }

    // For demo borrowing - expose books list (not best practice in real OOP, but ok for demo)
    public List<Book> getBooks() {
        return books;
    }
}

// Member class
class Member {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed book: " + book.getTitle());
    }

    // Show all borrowed books
    public void showBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            book.showDetails();
        }
    }
}

// Demo class
public class LibraryDemo {
    public static void main(String[] args) {
        // Step 1 - Create Library
        Library lib = new Library("Central City");
        // Step 2 - Create Book objects
        Book b1 = new Book("Head First Java", "Kathy Sierra", "111-2345");
        Book b2 = new Book("Design Patterns", "Erich Gamma", "222-4567");
        Book b3 = new Book("Clean Code", "Robert Martin", "333-6789");
        // Step 3 - Add books to library
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        // Step 4 - Show all books
        lib.showBooks();
        // Step 5 - Create Member
        Member mem = new Member("Ravi");
        // Step 6 - Borrow 2 books
        mem.borrowBook(b1);
        mem.borrowBook(b3);
        // Step 7 - Show borrowed books
        mem.showBorrowedBooks();
    }
}
