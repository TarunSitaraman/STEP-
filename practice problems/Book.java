public class Book {
    String title;
    String author;
    double price;
    // TODO: Default constructor
    Book() {
        title = "Walden";
        author = "Henry David Thoreau";
        price = 0.0;
    }
    // TODO: Parameterized constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }
    // TODO: Display method
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    public static void main(String[] args) {
    // TODO: Create book1 using default constructor
        Book book1 = new Book();
    // TODO: Create book2 using parameterized constructor
        Book book2 = new Book("1984", "George Orwell", 9.99);
    // TODO: Display both books
        book1.display();
        book2.display();
    }
}