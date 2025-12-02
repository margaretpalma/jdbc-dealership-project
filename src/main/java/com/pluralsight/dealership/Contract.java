package com.pluralsight.dealership;

public abstract class Contract {

    //base class - salescontract / leasecontract extend

    private String date;
    private String name;
    private String email;
    private Vehicle vehicleSold;

    public Contract(String date, String name, String email, Vehicle vehicleSold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public abstract double getTotalPrice();
    public abstract double getmonthlyPayment();



}
