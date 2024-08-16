package com.assetmanagement.service;

import com.assetmanagement.impl.HardwareAssignedImpl;
import com.assetmanagement.intf.HardwareAssignedIntf;
import com.assetmanagement.models.HardwareAssigned;
import com.assetmanagement.repository.HardwareAssignedRepository;

import java.time.LocalDate;
import java.util.*;

public class HardwareAssignedService {
	
	 private static HardwareAssignedIntf hardwareAssignedIntf;
	    private static Scanner scanner = new Scanner(System.in);
	    
	    public HardwareAssignedService(HardwareAssignedRepository HardwareAssignedRepo) {
	        this.hardwareAssignedIntf = new HardwareAssignedImpl(HardwareAssignedRepo);
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

	    public static void addHardwareAssigned() {
        System.out.print("Enter Hardware Assigned ID: ");
        int id = getValidInt();
        System.out.print("Enter Hardware Asset ID: ");
        int assetID = getValidInt();
        System.out.print("Enter Employee ID: ");
        int employeeID = getValidInt();
        System.out.print("Enter Assigned By: ");
        String assignedBy = scanner.next();
        System.out.print("Enter Assigned Date (YYYY-MM-DD): ");
        String[] parts = scanner.next().split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        System.out.print("Enter Assigned Status: ");
        String status = scanner.next();
        hardwareAssignedIntf.addHardwareAssigned(new HardwareAssigned(id, assetID, employeeID, assignedBy, date, status));
        System.out.println("Hardware assigned added successfully.");
    }

	    public static void removeHardwareAssigned() {
        System.out.print("Enter Hardware Assigned ID to remove: ");
        int id = getValidInt();
        hardwareAssignedIntf.removeHardwareAssigned(id);
        System.out.println("Hardware assigned removed successfully.");
    }

	    public static void updateHardwareAssigned() {
        System.out.print("Enter Hardware Assigned ID to update: ");
        int id = getValidInt();
        System.out.print("Enter new Hardware Asset ID: ");
        int assetID = getValidInt();
        System.out.print("Enter new Employee ID: ");
        int employeeID = getValidInt();
        System.out.print("Enter new Assigned By: ");
        String assignedBy = scanner.next();
        System.out.print("Enter new Assigned Date (YYYY-MM-DD): ");
        String[] parts = scanner.next().split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        System.out.print("Enter new Assigned Status: ");
        String status = scanner.next();
        hardwareAssignedIntf.updateHardwareAssigned(new HardwareAssigned(id, assetID, employeeID, assignedBy, date, status));
        System.out.println("Hardware assigned updated successfully.");
    }

	    public static void getHardwareAssigned() {
        System.out.print("Enter Hardware Assigned ID to retrieve: ");
        int id = getValidInt();
        HardwareAssigned assigned = hardwareAssignedIntf.getHardwareAssigned(id);
        if (assigned != null) {
            System.out.printf("%-10s %-15s %-15s %-20s %-20s %-15s%n",
                              "ID", "Asset ID", "Employee ID", "Assigned By", "Assigned Date", "Status");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.printf("%-10d %-15d %-15d %-20s %-20s %-15s%n",
                              assigned.getHardwareAssignedID(),
                              assigned.getHardwareAssetID(),
                              assigned.getEmployeeID(),
                              assigned.getAssignedBy(),
                              assigned.getAssignedDate(),
                              assigned.getAssignedStatus());
        } else {
            System.out.println("Hardware assigned not found.");
        }
    }

	    public static void listAllHardwareAssigned() {
        List<HardwareAssigned> assignedList = hardwareAssignedIntf.getAllHardwareAssigned();
        // Print table header
        System.out.printf("%-10s %-15s %-15s %-20s %-20s %-15s%n", 
                          "ID", "Asset ID", "Employee ID", "Assigned By", "Assigned Date", "Status");
        System.out.println("----------------------------------------------------------------------------------------");
        // Print each record in the table
        if (!assignedList.isEmpty()) {
            for (HardwareAssigned assigned : assignedList) {
                System.out.printf("%-10d %-15d %-15d %-20s %-20s %-15s%n",
                                  assigned.getHardwareAssignedID(),
                                  assigned.getHardwareAssetID(),
                                  assigned.getEmployeeID(),
                                  assigned.getAssignedBy(),
                                  assigned.getAssignedDate(),
                                  assigned.getAssignedStatus());
            }
        } else {
            System.out.println("No hardware assignments to display.");
        }
    }
	
}
