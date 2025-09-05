import java.text.SimpleDateFormat;
import java.util.*;

class Book {
    String bookId, title, author;
    String dueDate, returnDate;
    double fine;

    Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void setDueDate(String date) { dueDate = date; }
    void setReturnDate(String date) { 
        returnDate = date; 
        fine = calculateFine();
    }

    double calculateFine() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date due = sdf.parse(dueDate);
            Date returned = sdf.parse(returnDate);
            long diffMs = returned.getTime() - due.getTime();
            long daysLate = diffMs / (1000 * 60 * 60 * 24);
            return daysLate > 0 ? daysLate * 5.0 : 0;
        } catch (Exception e) { return 0; }
    }
}

class Member {
    String name, memberId, contact;
    List<Book> borrowedBooks = new ArrayList<>();

    Member(String name, String memberId, String contact) {
        this.name = name;
        this.memberId = memberId;
        this.contact = contact;
    }
}

class LibraryManager {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    
    void addBook(String id, String title, String author) {
        books.add(new Book(id, title, author));
    }
    
    void addMember(String name, String id, String contact) {
        members.add(new Member(name, id, contact));
    }
    
    Member findMember(String memberId) {
        for (Member m : members)
            if (m.memberId.equals(memberId)) return m;
        return null;
    }

    Book findBook(String bookId) {
        for (Book b : books)
            if (b.bookId.equals(bookId)) return b;
        return null;
    }
    
    void borrowBook(String memberId, String bookId, String dueDate) {
        Member m = findMember(memberId);
        Book b = findBook(bookId);
        if (m != null && b != null) {
            b.setDueDate(dueDate);
            m.borrowedBooks.add(b);
            System.out.println(m.name + " borrowed " + b.title);
        }
    }
    
    void returnBook(String memberId, String bookId, String returnDate) {
        Member m = findMember(memberId);
        Book b = findBook(bookId);
        if (m != null && b != null && m.borrowedBooks.contains(b)) {
            b.setReturnDate(returnDate);
            System.out.println(m.name + " returned " + b.title + ". Fine: ₹" + b.fine);
        }
    }
    
    void showMemberDetails(String memberId) {
        Member m = findMember(memberId);
        if (m != null) {
            System.out.println("Member: " + m.name);
            for (Book b : m.borrowedBooks) {
                System.out.println("Book: " + b.title + ", Due: " + b.dueDate + ", Returned: " + b.returnDate + ", Fine: ₹" + b.fine);
            }
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();
        lm.addBook("B01", "Java Programming", "Ravi Kumar");
        lm.addBook("B02", "DBMS Concepts", "Seema Rao");
        lm.addMember("Arjun", "M101", "9988001112");
        lm.addMember("Meena", "M102", "9988001122");

        lm.borrowBook("M101", "B01", "01-09-2025");
        lm.returnBook("M101", "B01", "10-09-2025"); // 9 days late

        lm.showMemberDetails("M101");
    }
}
