package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1, 89.00, false, false);
        System.out.println("Beds: " + room1.getNumberOfBeds());
        System.out.println("Price: " + room1.getPrice());
        System.out.println("Occupied: " + room1.isOccupied());
        System.out.println("Dirty: " + room1.isDirty());
        System.out.println(("Available: " + room1.isAvailable()));

        Reservation r = new Reservation("king", 3, true);
        System.out.println("Room type: " + r.getRoomType());
        System.out.println("Price per night: " + r.getPrice());
        System.out.println("Number of nights: " + r.getNumberOfNights());
        System.out.printf("Total: $%.2f%n", r.getReservationTotal());

        Employee employee1 = new Employee(1, "Mercy", "Front Desk", 80.00, 50);
        System.out.println(employee1.getName() + " total pay: $" + employee1.getTotalPay());
        System.out.println("Regular hours: " + employee1.getRegularHours());
        System.out.println("Overtime hours: " + employee1.getOvertimeHours());

    }
}
