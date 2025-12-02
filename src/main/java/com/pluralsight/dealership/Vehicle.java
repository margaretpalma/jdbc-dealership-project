package com.pluralsight.dealership;

public class Vehicle {
//define what a vehicle is


    //what do we know?
    private int vehicleVin;
    private int vehicleYear;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String vehicleColor;
    private int odometer;
    private double price;

    //constructor
    public Vehicle(int vehicleVin, int vehicleYear, String vehicleMake, String vehicleModel, String vehicleType,
                   String vehicleColor, int odometer, double price) {
        this.vehicleVin = vehicleVin;
        this.vehicleYear = vehicleYear;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVehicleVin() {
        return vehicleVin;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle|" +
                " Vin " + vehicleVin +
                " | Year - " + vehicleYear +
                " | Make - " + vehicleMake +
                " | Model - " + vehicleModel +
                " | Type - " + vehicleType +
                " | Color - " + vehicleColor +
                " | Odometer - " + odometer +
                " | Price - " + price +
                '|';
    }

    public String toFileFormat() {
        //save to file
        return vehicleVin + "|"
                + vehicleYear
                + "|" + vehicleMake
                + "|" + vehicleModel
                + "|" + vehicleType
                + "|" + vehicleColor
                + "|" + odometer
                + "|" + price;
    }
}