package com.assetmanagement;

import com.assetmanagement.repository.*;
import com.assetmanagement.service.AdminService;
import com.assetmanagement.service.EmployeeService;
import com.assetmanagement.service.HardwareAssetService;
import com.assetmanagement.service.HardwareAssignedService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AssetManagementApplication {
    
    private static AdminService admin;
    private static EmployeeService employee;
    private static HardwareAssetService hardware;
    private static HardwareAssignedService assigned;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    	EmployeeRepository employeeRepo = new EmployeeRepository();
        AdminRepository adminRepo = new AdminRepository();
        HardwareAssetRepository hardwareAssetRepo = new HardwareAssetRepository();
        HardwareAssignedRepository hardwareAssignedRepo = new HardwareAssignedRepository();

        employee = new EmployeeService(employeeRepo);
        admin = new AdminService(adminRepo);
        hardware = new HardwareAssetService(hardwareAssetRepo);
        assigned = new HardwareAssignedService(hardwareAssignedRepo);

        boolean running = true;
        while (running) {
            System.out.println("Asset Management System");
            System.out.println("1. Admin Operations");
            System.out.println("2. Hardware Asset Operations");
            System.out.println("3. Employee Operations");
            System.out.println("4. Hardware Assigned Operations");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = getValidInt();

            switch (choice) {
                case 1:
                    handleAdminOperations();
                    break;
                case 2:
                    handleHardwareAssetOperations();
                    break;
                case 3:
                    handleEmployeeOperations();
                    break;
                case 4:
                    handleHardwareAssignedOperations();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void handleAdminOperations() {
        System.out.println("Admin Operations");
        System.out.println("1. Add Admin");
        System.out.println("2. Remove Admin");
        System.out.println("3. Update Admin");
        System.out.println("4. Get Admin");
        System.out.println("5. List All Admins");
        System.out.println("6. Back to Main Menu");

        int choice = getValidInt();
        switch (choice) {
            case 1:
                admin.addAdmin();
                break;
            case 2:
                admin.removeAdmin();
                break;
            case 3:
                admin.updateAdmin();
                break;
            case 4:
                admin.getAdmin();
                break;
            case 5:
                admin.listAllAdmins();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private static void handleHardwareAssetOperations() {
        System.out.println("Hardware Asset Operations");
        System.out.println("1. Add Hardware Asset");
        System.out.println("2. Remove Hardware Asset");
        System.out.println("3. Update Hardware Asset");
        System.out.println("4. Get Hardware Asset");
        System.out.println("5. List All Hardware Assets");
        System.out.println("6. Back to Main Menu");

        int choice = getValidInt();
        switch (choice) {
            case 1:
                hardware.addHardwareAsset();
                break;
            case 2:
                hardware.removeHardwareAsset();
                break;
            case 3:
                hardware.updateHardwareAsset();
                break;
            case 4:
                hardware.getHardwareAsset();
                break;
            case 5:
                hardware.listAllHardwareAssets();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private static void handleEmployeeOperations() {
        System.out.println("Employee Operations");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Get Employee");
        System.out.println("5. List All Employees");
        System.out.println("6. Back to Main Menu");

        int choice = getValidInt();
        switch (choice) {
            case 1:
                employee.addEmployee();
                break;
            case 2:
                employee.removeEmployee();
                break;
            case 3:
                employee.updateEmployee();
                break;
            case 4:
                employee.getEmployee();
                break;
            case 5:
                employee.listAllEmployees();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private static void handleHardwareAssignedOperations() {
        System.out.println("Hardware Assigned Operations");
        System.out.println("1. Add Hardware Assigned");
        System.out.println("2. Remove Hardware Assigned");
        System.out.println("3. Update Hardware Assigned");
        System.out.println("4. Get Hardware Assigned");
        System.out.println("5. List All Hardware Assigned");
        System.out.println("6. Back to Main Menu");

        int choice = getValidInt();
        switch (choice) {
            case 1:
                assigned.addHardwareAssigned();
                break;
            case 2:
                assigned.removeHardwareAssigned();
                break;
            case 3:
                assigned.updateHardwareAssigned();
                break;
            case 4:
                assigned.getHardwareAssigned();
                break;
            case 5:
                assigned.listAllHardwareAssigned();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private static int getValidInt() {
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
