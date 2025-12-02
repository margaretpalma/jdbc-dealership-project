package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.Iterator;

public class Dealership {
    // what do we know?
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    // constructor
    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // return list
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;

    }

    // adding vehicle
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        // todo: print for adding vehicle to inventory
    }

    // remove a vehicle by VIN
    public ArrayList<Vehicle> removeVehicle(int vehicleVin) {
        Iterator<Vehicle> it = inventory.iterator();
        while (it.hasNext()) {
            Vehicle v = it.next();
            if (v.getVehicleVin() == vehicleVin) {
                it.remove();
            }
        }
        return null;
    }


    //price range
    public ArrayList<Vehicle> findByPriceRange(double minPrice, double maxPrice) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : inventory) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                results.add(v);
            }
        }
        return results;
    }

//todo: fix this

    // find by make and model
    public ArrayList<Vehicle> findByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();

        // Normalize input (avoid null pointer)
        String makeLower = (make == null) ? "" : make.toLowerCase();
        String modelLower = (model == null) ? "" : model.toLowerCase();

        // loop through inventory
        for (Vehicle v : inventory) {
            String vehicleMake = v.getVehicleMake().toLowerCase();
            String vehicleModel = v.getVehicleModel().toLowerCase();

            //make and model
            if (vehicleMake.contains(makeLower) &&
                    (modelLower.isEmpty() || vehicleModel.contains(modelLower))) {

                results.add(v);
            }
        }

        return results;
    }

    //find by year

    public ArrayList<Vehicle> findByYear(int minYear, int maxYear) {

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleYear() >= minYear && v.getVehicleYear() <= maxYear) {
                results.add(v);
            }
        }
        return results;

    }

    //find by color
    public ArrayList<Vehicle> findByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();
        String colorLower = (color == null) ? "" : color.toLowerCase();
        for (Vehicle v : inventory) {
            if (v.getVehicleColor().toLowerCase().contains(colorLower)) {
                results.add(v);
            }
        }
        return results;
    }


    //todo: find by mile range
// Find by mileage range
    public ArrayList<Vehicle> findByMileageRange(int minMiles, int maxMiles) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : inventory) {
            if (v.getOdometer() >= minMiles && v.getOdometer() <= maxMiles) {
                results.add(v);
            }
        }

        return results;
    }

//find by type

    public ArrayList<Vehicle> findByType(String type) {
        ArrayList<Vehicle> results = new ArrayList<>();

        String typeLower = (type == null) ? "" : type.toLowerCase();

        for (Vehicle v : inventory) {
            if (v.getVehicleType().toLowerCase().contains(typeLower)){
                results.add(v);
            }
        }
        return results;
    }
//find by vin

    public Vehicle findByVehicleVin(int vin){
        for(Vehicle v : inventory){
            if(v.getVehicleVin() == vin){
                return v;
            }
        }
        return null;
    }
}

