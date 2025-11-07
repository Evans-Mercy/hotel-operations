package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //holds information about the dealership (name, address and list of vehicles)
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); //initializes the arraylist
    }

    //getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    //returns a copy
    public List<Vehicle> getAllVehicles(){
        return new ArrayList<>(inventory);
    }

    //add a vehicle
    public void addVehicle(Vehicle v){
        this.inventory.add(v);
    }

    //search by price
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    //search by make
    public List<Vehicle> getVehiclesByMake(String make, String model){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                result.add(v);
            }
        }
        return result;
    }

    //search by year
    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getYear() >= min && v.getYear() <= max){
                result.add(v);
            }
        }
        return result;
    }

    //search by color
    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getColor().equalsIgnoreCase(color)){
                result.add(v);
            }
        }
        return result;
    }

    //search by mileage
    public List<Vehicle> getVehiclesByMileage(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getOdometer() >= min && v.getOdometer() <= max){
                result.add(v);
            }
        }
        return result;
    }

    //search by vehicle type
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(v);
            }
        }
        return result;
    }

    //remove a vehicle
    public void removeVehicle(Vehicle vehicle){
       inventory.remove(vehicle);
    }
}
