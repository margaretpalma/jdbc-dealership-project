package com.pluralsight.dealership;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * 0.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double leaseFee = getVehicleSold().getPrice() * 0.07;
        return getVehicleSold().getPrice() + leaseFee;
    }

    /* Expected ending value 50% of original price
    Lease fee 7% of original price
    Monthly payment based on Lease Finanaced at 4.0% for 36 months
     */

    @Override
    public double getmonthlyPayment(){
        double rate = 0.04 / 12;
        int months = 36;
        double price = getTotalPrice();
        double principle = price - expectedEndingValue;
        return (principle * rate) / (1 - Math.pow(1 + rate, -months));


    }
}
