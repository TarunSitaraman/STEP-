class LibraryUser {
    String name;
    int userID;

    LibraryUser(String name, int userID) {
        this.name = name;
        this.userID = userID;
    }

    void logEntry() {
        System.out.println(name + " (ID: " + userID + ") entered the library.");
    }

    void displayInfo() {
        System.out.println("Library User: " + name + " | ID: " + userID);
    }
}

class Student extends LibraryUser {
    Student(String name, int userID) {
        super(name, userID);
    }

    void borrowBook(String book) {
        System.out.println(name + " borrows book: " + book);
    }

    void accessComputer() {
        System.out.println(name + " accesses library computer.");
    }
}

class Faculty extends LibraryUser {
    Faculty(String name, int userID) {
        super(name, userID);
    }

    void reserveBook(String book) {
        System.out.println(name + " reserves book: " + book);
    }

    void accessResearchDatabase() {
        System.out.println(name + " accesses research databases.");
    }
}

class Guest extends LibraryUser {
    Guest(String name, int userID) {
        super(name, userID);
    }

    void browseBooks() {
        System.out.println(name + " browses books in the library.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryUser[] users = {
            new Student("Arjun", 1001),
            new Faculty("Dr. Meera", 2001),
            new Guest("Sawant", 3001)
        };

        for (LibraryUser user : users) {
            user.logEntry();
            user.displayInfo();
            System.out.println("---");
        }
    }
}
