package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Dealership d = new Dealership("Jeep", "222 Offroad str", "245-678");

        Vehicle v1 = new Vehicle(2589, 2025, "Wrangler", "Sahara", "SUV", "Granite gray", 20000,2.00);

        d.addVehicle(v1);
        System.out.println("Dealership: " +d.getName() + v1);
    }
}
