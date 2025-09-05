class Room {
    int roomNumber;
    String type; // e.g., "Deluxe", "Standard"
    boolean occupied;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.occupied = false;
    }
}

class Guest {
    String name;
    String contact;

    Guest(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}

class Booking {
    Room room;
    Guest guest;
    String checkIn;
    String checkOut;

    Booking(Room room, Guest guest, String checkIn, String checkOut) {
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}

class HotelManager {
    Room[] rooms = new Room;
    Guest[] guests = new Guest;
    Booking[] bookings = new Booking;
    int roomCount = 0, guestCount = 0, bookingCount = 0;

    void addRoom(int num, String type) {
        rooms[roomCount++] = new Room(num, type);
    }

    void addGuest(String name, String contact) {
        guests[guestCount++] = new Guest(name, contact);
    }

    Room findAvailableRoom(String type) {
        for (int i = 0; i < roomCount; i++) {
            if (!rooms[i].occupied && rooms[i].type.equals(type)) return rooms[i];
        }
        return null;
    }

    void bookRoom(String guestName, String roomType, String checkIn, String checkOut) {
        Guest guest = null;
        for (int i = 0; i < guestCount; i++) {
            if (guests[i].name.equals(guestName)) guest = guests[i];
        }
        Room room = findAvailableRoom(roomType);
        if (guest != null && room != null) {
            bookings[bookingCount++] = new Booking(room, guest, checkIn, checkOut);
            room.occupied = true;
            System.out.println("Booked Room " + room.roomNumber + " for " + guestName);
        } else {
            System.out.println("Booking failed: Check guest and room availability");
        }
    }

    void viewBookings() {
        System.out.println("Current Bookings:");
        for (int i = 0; i < bookingCount; i++) {
            System.out.println(
                "Room: " + bookings[i].room.roomNumber +
                " | Guest: " + bookings[i].guest.name +
                " | Check-in: " + bookings[i].checkIn +
                " | Check-out: " + bookings[i].checkOut
            );
        }
    }
}

public class HotelReservationApp {
    public static void main(String[] args) {
        HotelManager manager = new HotelManager();
        manager.addRoom(101, "Deluxe");
        manager.addRoom(102, "Standard");
        manager.addGuest("Arjun", "1234567890");
        manager.addGuest("Meena", "9876543210");

        manager.bookRoom("Arjun", "Deluxe", "2025-09-10", "2025-09-15");
        manager.bookRoom("Meena", "Standard", "2025-09-12", "2025-09-16");

        manager.viewBookings();
    }
}
