package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //holds dealership data
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        //loads dealership info as soon as UserInterface starts
        init();
    }

    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();

        this.dealership = fileManager.getDealership();

        if (dealership == null) {
            System.out.println("Failed to load dealership data.");
        } else {
            System.out.println("Welcome to " + dealership.getName() + "!");
        }
    }

    //main display method
    public void display(){
        boolean running = true;

        while (running){
            System.out.println("\n---------------------------");
            System.out.println("Soft Life Motors Menu");
            System.out.println("Fueled by Coffee & Chaos");
            System.out.println("---------------------------");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 99:
                    System.out.println("Exiting The SlayWay...Bye Queen!");
                    running = false;
                    break;
                default:
                    System.out.println("NO BOYS ALLOWED! BOO!!");
                    break;
            }
        }
    }

    //all vehicles
    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();

        if (vehicles.isEmpty()) {
            System.out.println("No toys...jk no convertibles in inventory.");
        } else {
            displayVehicles(vehicles);
        }
    }

    //display vehicles
    private void displayVehicles (List<Vehicle> vehicles) {
        System.out.println("\n-------Current Convertibles Inventory------");
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }
}
