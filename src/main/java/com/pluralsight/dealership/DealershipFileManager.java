package com.pluralsight.dealership;

import com.pluralsight.dealership.models.Dealership;
import com.pluralsight.dealership.models.Vehicle;

import java.io.*;

public class DealershipFileManager {

    private String filename; // file read/write

    // constructor
    public DealershipFileManager(String filename) {
        this.filename = filename;
    }

    // read dealership from file
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // dealership info name|address|phone
            String line = br.readLine();

            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);
            }

            //------------------------
            // read vehicles

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int vehicleYear = Integer.parseInt(parts[1]);
                String vehicleMake = parts[2];
                String vehicleModel = parts[3];
                String vehicleType = parts[4];
                String vehicleColor = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle v = new Vehicle(vin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor, odometer, price);
                // add vehicle to dealership
                dealership.addVehicle(v);

            }
            // catching exception
        } catch (IOException e) {

            System.out.println("Error Reading File: " + e.getMessage());
        }

        return dealership;
    }
    //---------------------------
    // dealership goes to file

    //save to file
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // write dealership info
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
            bw.newLine();

            for(Vehicle v : dealership.getAllVehicles()){
                bw.write(v.toFileFormat());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error Writing File: " + e.getMessage()); // fixed typo
        }


    }
}

