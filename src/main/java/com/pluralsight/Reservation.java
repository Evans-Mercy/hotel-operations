package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getPrice(){
        double pricePerNight;

        if (roomType.equals("king")) {
            pricePerNight = 139.00;
        } else {
            pricePerNight = 124.00;
        }

        if (isWeekend) {
            pricePerNight = pricePerNight * 1.10;
        }

        return pricePerNight;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }

}
