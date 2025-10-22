package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private  int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    //derived getters
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    //book room method
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= getAvailableSuites()) {
                bookedSuites += numberOfRooms;
                System.out.println(numberOfRooms + "suite(s) booked.");
                return true;
            } else {
                System.out.println("Not enough suites available.");
                return false;
            }
        } else {
            if (numberOfRooms <= getAvailableRooms()) {
                bookedBasicRooms += numberOfRooms;
                System.out.println(numberOfRooms + "basic room(s) booked.");
                return true;
            } else {
                System.out.println("Not enough basic rooms available.");
                return false;
            }
        }
    }
}
