package com.pluralsight;

import java.io.*;
import java.util.List;

public class DealershipFileManager {
    private final String fileName = "src/main/resources/inventory.csv";

    //reads the file, parsing the data, dealership object - vehicles, save a dealership
    public Dealership getDealership(){

      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

          //first line - dealership info
          String line = reader.readLine();
          String[] lineParts = line.split("\\|");
          Dealership dealership = new Dealership(lineParts[0], lineParts[1], lineParts[2]);

          //remaining lines - vehicles
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

      //save dealership back to file
    public void saveDealership(Dealership dealership) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            //first line - dealership info
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" +dealership.getPhone());
            writer.newLine();

            //remaining lines - vehicles
            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle v : vehicles) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }
        }catch (IOException e) {
            System.out.println("Error saving that data queen: " + e.getMessage());
        }
    }
}
