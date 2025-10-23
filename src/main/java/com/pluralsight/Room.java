package com.pluralsight;

public class Room {

    //backing variables aka private fields
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    //derived getter
    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public void checkIn(){
        if (!isAvailable()) {
            System.out.println("Room is not available for check-in.");
        } else {
            isOccupied = true;
            isDirty = true;
            System.out.println("Guest checked in. Room is now occupied and dirty.");
        }
    }

    public void checkOut(){
        if (!isOccupied) {
            System.out.println("Room is already vacant");
        } else {
            isDirty = false;
            System.out.println("Guest checked out. Room is now vacant but dirty.");
        }
    }

    public void cleanRoom() {
        if (!isDirty) {
            System.out.println("Room is already clean.");
        } else {
            isDirty = false;
            System.out.println("Room has been cleaned and is now available");
        }
    }
}
