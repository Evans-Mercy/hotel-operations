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

    public void addVehicle(Vehicle v){
        this.inventory.add(v);
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByMake(String make, String model){
        return null;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        return null;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        return null;
    }
    public List<Vehicle> getVehiclesByMileage(double min, double max){
        return null;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }
    public void removeVehicle(Vehicle vehicle){
       inventory.remove(vehicle);
    }
}
