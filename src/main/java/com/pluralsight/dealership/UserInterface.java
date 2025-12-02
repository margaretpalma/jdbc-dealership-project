package com.pluralsight.dealership;

import java.util.ArrayList;

public class UserInterface {

    // load dealership from file
    private Dealership dealership;

    // display menu
    public void display() {
        init();

        int command;

        // main loop
        while (true) {
            displayMenu();

            command = ConsoleHelper.promptForInt("Enter Command");

            // switch statements for menu
            switch (command) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processMakeContractRequest();
                    break;
                case 99:
                    System.out.println("Exiting Program...");
                    return;
                default:
                    System.out.println("Invalid Option. Please Try Again.");
            }
        }
    }

    // initialize dealership data
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("DealershipFile.csv");
        this.dealership = fileManager.getDealership();

        if (dealership != null) {
            System.out.println("Dealership Loaded: " + dealership.getName());
        } else {
            System.out.println("Error Loading Dealership Data");
        }
    }

    // main menu display
    private void displayMenu() {
        System.out.println("***** Main Menu *****");
        System.out.println("1 - Find Vehicles By Price Range");
        System.out.println("2 - Find Vehicles By Make/Model");
        System.out.println("3 - Find Vehicles By Year Range");
        System.out.println("4 - Find Vehicles By Color");
        System.out.println("5 - Find Vehicles By Mileage Range");
        System.out.println("6 - Find Vehicles By Type (Car, Truck, Van)");
        System.out.println("7 - List All Vehicles");
        System.out.println("8 - Add A Vehicle");
        System.out.println("9 - Remove A Vehicle");
        System.out.println("10 - Create A New Contract");
        System.out.println("99 - Quit Program");
    }

    // list all vehicles
    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // helper method to display vehicles
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No Vehicles Found.");
            return;
        }

        System.out.println("--- Inventory List ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    // search by price range
    private void processGetByPriceRequest() {
        System.out.println("--- Search By Price Range ---");
        double minPrice = ConsoleHelper.promptForDouble("Enter Minimum Price");
        double maxPrice = ConsoleHelper.promptForDouble("Enter Maximum Price");

        ArrayList<Vehicle> results = dealership.findByPriceRange(minPrice, maxPrice);
        displayVehicles(results);
    }

    // search by year
    private void processGetByYearRequest() {
        System.out.println("--- Search By Year Range ---");
        int minYear = ConsoleHelper.promptForInt("Enter Minimum Year");
        int maxYear = ConsoleHelper.promptForInt("Enter Maximum Year");

        ArrayList<Vehicle> results = dealership.findByYear(minYear, maxYear);
        displayVehicles(results);
    }

    // search by color
    private void processGetByColorRequest() {
        System.out.println("--- Search By Color ---");
        String color = ConsoleHelper.promptForString("Enter Vehicle Color");

        ArrayList<Vehicle> results = dealership.findByColor(color);
        displayVehicles(results);
    }

    // search by make and model
    private void processGetByMakeModelRequest() {
        System.out.println("--- Search By Make/Model ---");
        String make = ConsoleHelper.promptForString("Enter Vehicle Make");
        String model = ConsoleHelper.promptForString("Enter Vehicle Model");

        ArrayList<Vehicle> results = dealership.findByMakeModel(make, model);
        displayVehicles(results);
    }

    // search by mileage range
    private void processGetByMileageRequest() {
        System.out.println("--- Search By Mileage Range ---");
        int minMiles = ConsoleHelper.promptForInt("Enter Minimum Mileage");
        int maxMiles = ConsoleHelper.promptForInt("Enter Maximum Mileage");

        ArrayList<Vehicle> results = dealership.findByMileageRange(minMiles, maxMiles);
        displayVehicles(results);
    }

    // search by type
    private void processGetByTypeRequest() {
        System.out.println("--- Search By Type ---");
        String type = ConsoleHelper.promptForString("Enter Vehicle Type (Car, Truck, Van)");

        ArrayList<Vehicle> results = dealership.findByType(type);
        displayVehicles(results);
    }

    // add vehicle
    private void processAddVehicleRequest() {
        System.out.println("--- Add Vehicle ---");

        int vehicleVin = ConsoleHelper.promptForInt("Enter Vin Number: ");
        int vehicleYear = ConsoleHelper.promptForInt("Enter Vehicle Year: ");
        String vehicleMake = ConsoleHelper.promptForString("Enter Vehicle Make: ");
        String vehicleModel = ConsoleHelper.promptForString("Enter Vehicle Model: ");
        String vehicleType = ConsoleHelper.promptForString("Enter Vehicle Type: ");
        String vehicleColor = ConsoleHelper.promptForString("Enter Vehicle Color: ");
        int odometer = ConsoleHelper.promptForInt("Enter Vehicle Mileage: ");
        double price = ConsoleHelper.promptForDouble("Enter Vehicle Price: ");

        Vehicle newVehicle = new Vehicle(vehicleVin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor, odometer, price);
        dealership.addVehicle(newVehicle);

        System.out.println("** Vehicle Added Successfully **");
    }

    // remove vehicle
    private void processRemoveVehicleRequest() {
        System.out.println("--- Remove A Vehicle ---");
        int removeVin = ConsoleHelper.promptForInt("Enter Vehicle VIN To Remove");

        dealership.removeVehicle(removeVin);
        System.out.println("** Vehicle Removed **");
    }

    // create contract
    private void processMakeContractRequest() {
        System.out.println("--- Create A New Contract ---");
        // todo: contract info lease&sale
        //contract details: type/date/name/email/vin
        //find vehicle
        //contract building
        //save contract
        //exception catching

        try {
            String type = ConsoleHelper.promptForString("Enter Contract Type - Lease Or Sale");
            String date = ConsoleHelper.promptForString("Enter Date (YYYY-MM-DD");
            String name = ConsoleHelper.promptForString("Enter Customer Name");
            String email = ConsoleHelper.promptForString("Enter Customer Email");
            int vin = ConsoleHelper.promptForInt("Enter Vehicle Vin");

            //find by vin
            Vehicle vehicle = dealership.findByVehicleVin(vin);
            if (vehicle == null) {
                System.out.println("Vehicle Not Found");
                return;
            }
            Contract contract;
            //sale
            if (type.equals("Sale")) {
                boolean financed = ConsoleHelper.promptForString("Financing? (YES/NO)").equalsIgnoreCase("yes");
                contract = new SalesContract(date, name, email, vehicle, financed);

                //lease
            } else if (type.equalsIgnoreCase("Lease")) {
                //isFinanced is true, no choice to finance w/ lease
                //fixed rate and months
                contract = new LeaseContract(date, name, email, vehicle);
            } else {
                System.out.println("Invalid Contract Type - Enter Sale Or Lease");
                return;
            }
            //save to
            ContractFileManager.saveContract(contract);
            dealership.removeVehicle(vehicle.getVehicleVin());

            System.out.println("Created And Saved Contract");
        } catch (Exception e) {
            System.out.println("Error Creating Contract" + e.getMessage());
        }
    }
}
