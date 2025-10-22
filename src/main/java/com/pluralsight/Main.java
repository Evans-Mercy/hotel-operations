package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1, 89.00, false, false);
        System.out.println("Beds: " + room1.getNumberOfBeds());
        System.out.println("Price: " + room1.getPrice());
        System.out.println("Occupied: " + room1.isOccupied());
        System.out.println("Dirty: " + room1.isDirty());
        System.out.println(("Is room available? " + room1.isAvailable()));

        room1.checkIn();
        System.out.println("Occupied? " + room1.isOccupied());
        System.out.println("Dirty? " + room1.isDirty());
        Reservation r = new Reservation("king", 3, true);
        System.out.println("Room type: " + r.getRoomType());
        System.out.println("Price per night: " + r.getPrice());
        System.out.println("Number of nights: " + r.getNumberOfNights());
        System.out.printf("Total: $%.2f%n", r.getReservationTotal());

        room1.checkOut();
        System.out.println("Dirty? " + room1.isDirty());
        System.out.println("Available? " + room1.isAvailable());



        Employee employee1 = new Employee(1001, "Mercy", "Front Desk", 80.00, 8.5);
        employee1.punchIn();
        employee1.punchOut(18.00);

        System.out.printf("Total hours worked: %.2f%n", employee1.getHoursWorked());
        System.out.printf("Regular hours: %.2f%n", employee1.getRegularHours());
        System.out.println("Overtime hours: " + employee1.getOvertimeHours());
        System.out.printf("%d %s total pay: $%.2f%n", employee1.getEmployeeId(), employee1.getName(), employee1.getTotalPay());
    }
}
