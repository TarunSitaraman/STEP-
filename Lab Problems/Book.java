public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + "]";
    }
}

class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "John Doe");
        Book b2 = new Book("Java Programming", "John Doe");

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        System.out.println("\nReference comparison (==): " + (b1 == b2));
        System.out.println("Content comparison (.equals()): " + b1.equals(b2));
    }
}
