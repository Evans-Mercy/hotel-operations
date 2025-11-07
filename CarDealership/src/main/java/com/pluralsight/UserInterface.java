package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //holds dealership data
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);
    private final DealershipFileManager fileManager = new DealershipFileManager();

    public UserInterface() {
        //loads dealership info as soon as UserInterface starts
        init();
    }

    //loads dealership from file
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
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
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

    //price request
    private void processGetByPriceRequest(){
        System.out.println("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(result);
    }

    //make model
    private void processGetByMakeRequest(){
        System.out.println("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByMake(make, model);
        displayVehicles(result);
    }

    //year
    private void processGetByYearRequest(){
        System.out.println("Enter minimum year: ");
        int minYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByPrice(minYear, maxYear);
        displayVehicles(result);
    }


    //color
    private void processGetByVehicleTypeRequest(){
        System.out.println("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByType(type);
        displayVehicles(result);
    }

    //mileage
    private void processGetByMileageRequest(){
        System.out.println("Enter minimum mileage: ");
        double minMileage = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter maximum mileage: ");
        double maxMileage = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByPrice(minMileage, maxMileage);
        displayVehicles(result);
    }

    //vehicle type
    private void processGetByColorRequest(){
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();

        List<Vehicle> result = dealership.getVehiclesByColor(color);
        displayVehicles(result);
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

    //add a new vehicle
    private void processAddVehicleRequest(){
        System.out.println("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter make: ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter type: ");
        String type = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added and saved successfully!");
    }

    //remove a vehicle by vin
    private void processRemoveVehicleRequest() {
        System.out.println("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getAllVehicles();

        boolean removed = false;
        for(Vehicle v : vehicles){
            if (v.getVin() == vin){
                dealership.removeVehicle(v);
                removed= true;
                break;
            }
        }

        if (removed) {
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed and changes saved");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found");
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
