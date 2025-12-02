package com.pluralsight.dealership;

import java.util.Scanner;

public class ConsoleHelper {
    //user input
    private static Scanner scanner = new Scanner(System.in);

    //prompt for user string, int, float
    public static String promptForString(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt) {

        boolean isValid = false;
        int result = 0;
        do {
            try {
                System.out.println(prompt + ": ");
                result = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            } catch (Exception ex) {                  //catching exceptions
                scanner.nextLine();
                System.out.println("Invalid entry.");
            }
        } while (!isValid);
        return result;
    }

    public static float promptForFloat(String prompt) {
        System.out.println(prompt + ": ");
        float result = scanner.nextFloat();
        scanner.nextLine();
        return result;
    }

    public static double promptForDouble(String prompt) {
        System.out.println(prompt + ": ");
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;


    }
}
