package com.pluralsight.dealership;

public class SalesContract extends Contract{

    private double salesTax ;
    //never changes
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String name, String email, Vehicle vehicleSold,
                         boolean isFinanced) {
        super(date, name, email, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;

    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getmonthlyPayment() {
        if(!isFinanced) return 0;
        double loanRate;
        int months;

        if(getVehicleSold().getPrice() >= 10000){
            loanRate = 0.0425;
            months = 48;
        } else {
            loanRate = 0.0525;
            months = 24;
        }

        double monthlyRate = loanRate / 12;
        double price = getTotalPrice();
        return (price * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}

/* Sales tax amount 5%
        Recording Fee $100
        Processing Fee $295 for vehicle under 10,000 , $495 for all others
        Finance Yes/No
        Monthly Payment - All loans are 4.25% for 48 months if price is 10,000 or more
            if not 10,000 or more, 5.25% for 24 months
     */

//todo: overrides for getTotalPrice and getMonthlyPayment();

