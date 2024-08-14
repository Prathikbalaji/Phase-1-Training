package com.assetmanagement.service;

import com.assetmanagement.impl.HardwareAssetImpl;
import com.assetmanagement.models.HardwareAsset;
import com.assetmanagement.repository.HardwareAssetRepository;

import java.time.LocalDate;
import java.util.*;

public class HardwareAssetService {

    private static HardwareAssetImpl hardwareAssetImpl;
    private static Scanner scanner = new Scanner(System.in);

    public HardwareAssetService(HardwareAssetRepository hardwareAssetRepo) {
        this.hardwareAssetImpl = new HardwareAssetImpl(hardwareAssetRepo);
    }

    public static void addHardwareAsset() {
        System.out.print("Enter Hardware Asset ID: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter Asset Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces

        System.out.print("Enter Asset Type: ");
        String type = scanner.nextLine(); // Use nextLine() to allow spaces

        System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
        LocalDate date = getValidDate();

        System.out.print("Enter Purchase Price: ");
        double price = getValidDouble();

        System.out.print("Enter Warranty Period (months): ");
        int warranty = getValidInt();

        System.out.print("Enter Asset Status: ");
        String status = scanner.nextLine(); // Use nextLine() to allow spaces

        hardwareAssetImpl.addHardwareAsset(new HardwareAsset(id, name, type, date, price, warranty, status));
        System.out.println("Hardware asset added successfully.");
    }

    public static void removeHardwareAsset() {
        System.out.print("Enter Hardware Asset ID to remove: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        hardwareAssetImpl.removeHardwareAsset(id);
        System.out.println("Hardware asset removed successfully.");
    }

    public static void updateHardwareAsset() {
        System.out.print("Enter Hardware Asset ID to update: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter new Asset Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces

        System.out.print("Enter new Asset Type: ");
        String type = scanner.nextLine(); // Use nextLine() to allow spaces

        System.out.print("Enter new Purchase Date (YYYY-MM-DD): ");
        LocalDate date = getValidDate();

        System.out.print("Enter new Purchase Price: ");
        double price = getValidDouble();

        System.out.print("Enter new Warranty Period (months): ");
        int warranty = getValidInt();

        System.out.print("Enter new Asset Status: ");
        String status = scanner.nextLine(); // Use nextLine() to allow spaces

        hardwareAssetImpl.updateHardwareAsset(new HardwareAsset(id, name, type, date, price, warranty, status));
        System.out.println("Hardware asset updated successfully.");
    }

    public static void getHardwareAsset() {
        System.out.print("Enter Hardware Asset ID to retrieve: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        HardwareAsset asset = hardwareAssetImpl.getHardwareAsset(id);
        if (asset != null) {
            System.out.printf("%-10s %-20s %-15s %-15s %-15s %-20s %-10s%n",
                              "ID", "Name", "Type", "Purchase Date", "Price", "Warranty (months)", "Status");
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-10d %-20s %-15s %-15s %-15.2f %-20d %-10s%n",
                              asset.getHardwareAssetID(),
                              asset.getAssetName(),
                              asset.getAssetType(),
                              asset.getPurchaseDate(),
                              asset.getPurchasePrice(),
                              asset.getWarrantyPeriod(),
                              asset.getAssetStatus());
        } else {
            System.out.println("Hardware asset not found.");
        }
    }

    public static void listAllHardwareAssets() {
        List<HardwareAsset> assets = hardwareAssetImpl.getAllHardwareAssets();
        // Print table header
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-20s %-10s%n", 
                          "ID", "Name", "Type", "Purchase Date", "Price", "Warranty (months)", "Status");
        System.out.println("--------------------------------------------------------------------------------------------------");
        // Print each record in the table
        if (!assets.isEmpty()) {
            for (HardwareAsset asset : assets) {
                System.out.printf("%-10d %-20s %-15s %-15s %-15.2f %-20d %-10s%n", 
                                  asset.getHardwareAssetID(),
                                  asset.getAssetName(),
                                  asset.getAssetType(),
                                  asset.getPurchaseDate(),
                                  asset.getPurchasePrice(),
                                  asset.getWarrantyPeriod(),
                                  asset.getAssetStatus());
            }
        } else {
            System.out.println("No hardware assets to display.");
        }
    }

    public static int getValidInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter an integer.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    public static double getValidDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a valid decimal number.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    public static LocalDate getValidDate() {
        while (true) {
            try {
                String dateInput = scanner.next();
                String[] parts = dateInput.split("-");
                return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            } catch (Exception e) {
                System.out.println("Invalid date, please enter in the format YYYY-MM-DD.");
            }
        }
    }
}
