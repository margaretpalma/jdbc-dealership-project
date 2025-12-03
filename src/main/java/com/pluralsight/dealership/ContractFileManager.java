package com.pluralsight.dealership;

import com.pluralsight.dealership.models.LeaseContract;
import com.pluralsight.dealership.models.SalesContract;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    //todo: add method to save the contract by appending it to contracts file

    public static void saveContract(Contract contract) {
        if (contract == null) return;

        try (FileWriter writer = new FileWriter("DealershipContracts.csv", true)) {

            writer.write("Contract Type|Date|Customer Name|Customer Email|VIN|Year|Make|Model|Type|Color|Odometer|Price|Extra 1|Extra 2|Extra" +
                    " 3|Finance Option|Total Price|Monthly Payment\n");


            if (contract instanceof SalesContract sc) {

                writer.write(String.format(
                        "SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%s|%.2f|%.2f%n",
                        sc.getDate(),
                        sc.getName(),
                        sc.getEmail(),
                        sc.getVehicleSold().getVehicleVin(),
                        sc.getVehicleSold().getVehicleYear(),
                        sc.getVehicleSold().getVehicleMake(),
                        sc.getVehicleSold().getVehicleModel(),
                        sc.getVehicleSold().getVehicleType(),
                        sc.getVehicleSold().getVehicleColor(),
                        sc.getVehicleSold().getOdometer(),
                        sc.getVehicleSold().getPrice(),
                        sc.getSalesTax(),
                        sc.getRecordingFee(),
                        sc.getProcessingFee(),
                        sc.isFinanced() ? "YES" : "NO",
                        sc.getTotalPrice(),
                        sc.getmonthlyPayment()
                ));
            }
            else if (contract instanceof LeaseContract lc) {
                writer.write(String.format(
                        "LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f%n",
                        lc.getDate(),
                        lc.getName(),
                        lc.getEmail(),
                        lc.getVehicleSold().getVehicleVin(),
                        lc.getVehicleSold().getVehicleYear(),
                        lc.getVehicleSold().getVehicleMake(),
                        lc.getVehicleSold().getVehicleModel(),
                        lc.getVehicleSold().getVehicleType(),
                        lc.getVehicleSold().getVehicleColor(),
                        lc.getVehicleSold().getOdometer(),
                        lc.getVehicleSold().getPrice(),
                        lc.getExpectedEndingValue(),
                        lc.getLeaseFee(),
                        lc.getTotalPrice(),
                        lc.getmonthlyPayment()
                ));
            }

        } catch (IOException e){
            System.out.println("Error saving contract" + e.getMessage());

        }

    }
}


