package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room r = new Room(1, 89.00, false, false);
        System.out.println("Beds: " + r.getNumberOfBeds());
        System.out.println("Price: " + r.getPrice());
        System.out.println("Occupied: " + r.isOccupied());
        System.out.println("Dirty: " + r.isDirty());
        System.out.println(("Available: " + r.isAvailable()));

        Reservation r = new Reservation("king", 3, true);
        System.out.println();

    }
}
