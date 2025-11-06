package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    //reads the file, parsing the data, dealership object- vehicles, save a dealership
    public Dealership getDealership(){
        String fileName = "src/main/resources/inventory.csv";

      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

          //first line
          String line = reader.readLine();
          String[] lineParts = line.split("\\|");
          Dealership dealership = new Dealership(lineParts[0], lineParts[1], lineParts[2]);

          //remaining lines
          while ((line = reader.readLine()) != null) {
              String [] v = line.split("\\|");

              int vin = Integer.parseInt(v[0]);
              int year = Integer.parseInt(v[1]);
              String make = v[2];
              String model = v[3];
              String vehicleType = v[4];
              String color = v[5];
              int odometer = Integer.parseInt(v[6]);
              double price = Double.parseDouble(v[7]);

              Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
              dealership.addVehicle(vehicle);
          }
          return dealership;

    } catch (FileNotFoundException e) {
          System.out.println("Can't find the inventory file: " + fileName);
      } catch (IOException e){
          System.out.println("I/O error:" + e);
      }
      return null;
      }

}
