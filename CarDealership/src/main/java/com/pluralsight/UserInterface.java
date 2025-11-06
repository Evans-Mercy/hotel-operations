package com.pluralsight;

public class UserInterface {
    //display
    Dealership dealership;

    public UserInterface() {
        DealershipFileManager fileManager = new DealershipFileManager();

        this.dealership = fileManager.getDealership();
    }
}
