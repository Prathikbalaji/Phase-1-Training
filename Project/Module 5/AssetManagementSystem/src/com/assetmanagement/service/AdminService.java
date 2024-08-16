package com.assetmanagement.service;

import com.assetmanagement.impl.AdminImpl;
import com.assetmanagement.intf.AdminIntf;
import com.assetmanagement.models.Admin;
import com.assetmanagement.repository.AdminRepository;

import java.util.*;

public class AdminService {

    private static AdminIntf adminIntf;
    private static Scanner scanner = new Scanner(System.in);

    public AdminService(AdminRepository adminRepo) {
        this.adminIntf = new AdminImpl(adminRepo);
    }

    public static void addAdmin() {
        System.out.print("Enter Admin ID: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces

        adminIntf.addAdmin(new Admin(id, name));
        System.out.println("Admin added successfully.");
    }

    public static void removeAdmin() {
        System.out.print("Enter Admin ID to remove: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        adminIntf.removeAdmin(id);
        System.out.println("Admin removed successfully.");
    }

    public static void updateAdmin() {
        System.out.print("Enter Admin ID to update: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter new Admin Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces

        adminIntf.updateAdmin(new Admin(id, name));
        System.out.println("Admin updated successfully.");
    }

    public static void getAdmin() {
        System.out.print("Enter Admin ID to retrieve: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        Admin admin = adminIntf.getAdmin(id);
        if (admin != null) {
            System.out.printf("%-10s %-20s%n", "ID", "Name");
            System.out.println("------------------------------");
            System.out.printf("%-10d %-20s%n", admin.getAdminID(), admin.getAdminName());
        } else {
            System.out.println("Admin not found.");
        }
    }

    public static void listAllAdmins() {
        List<Admin> admins = adminIntf.getAllAdmins();
        // Print table header
        System.out.printf("%-10s %-20s%n", "ID", "Name");
        System.out.println("------------------------------");
        // Print each record in the table
        if (!admins.isEmpty()) {
            for (Admin admin : admins) {
                System.out.printf("%-10d %-20s%n", admin.getAdminID(), admin.getAdminName());
            }
        } else {
            System.out.println("No admins to display.");
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
}
