package com.assetmanagement.service;

import com.assetmanagement.impl.EmployeeImpl;
import com.assetmanagement.intf.EmployeeIntf;
import com.assetmanagement.models.Employee;
import com.assetmanagement.repository.EmployeeRepository;

import java.util.*;

public class EmployeeService {

    private static EmployeeIntf employeeIntf;
    private static Scanner scanner = new Scanner(System.in);

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeIntf = new EmployeeImpl(employeeRepo);
    }

    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()
        
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        
        employeeIntf.addEmployee(new Employee(id, name, email, phone, designation));
        System.out.println("Employee added successfully.");
    }

    public static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()
        
        employeeIntf.removeEmployee(id);
        System.out.println("Employee removed successfully.");
    }

    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()
        
        System.out.print("Enter new Employee Name: ");
        String name = scanner.nextLine(); // Use nextLine() to allow spaces
        
        System.out.print("Enter new Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter new Phone Number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter new Designation: ");
        String designation = scanner.nextLine();
        
        employeeIntf.updateEmployee(new Employee(id, name, email, phone, designation));
        System.out.println("Employee updated successfully.");
    }

    public static void getEmployee() {
        System.out.print("Enter Employee ID to retrieve: ");
        int id = getValidInt();
        scanner.nextLine(); // Consume the newline left by nextInt()
        
        Employee employee = employeeIntf.getEmployee(id);
        if (employee != null) {
            System.out.printf("%-10s %-20s %-25s %-15s %-20s%n",
                              "ID", "Name", "Email", "Phone", "Designation");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-10d %-20s %-25s %-15s %-20s%n",
                              employee.getEmployeeID(),
                              employee.getEmployeeName(),
                              employee.getEmail(),
                              employee.getPhoneNumber(),
                              employee.getDesignation());
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void listAllEmployees() {
        List<Employee> employees = employeeIntf.getAllEmployees();
        // Print table header
        System.out.printf("%-10s %-20s %-25s %-15s %-20s%n", 
                          "ID", "Name", "Email", "Phone", "Designation");
        System.out.println("--------------------------------------------------------------------------");
        // Print each record in the table
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.printf("%-10d %-20s %-25s %-15s %-20s%n", 
                                  employee.getEmployeeID(),
                                  employee.getEmployeeName(),
                                  employee.getEmail(),
                                  employee.getPhoneNumber(),
                                  employee.getDesignation());
            }
        } else {
            System.out.println("No employees to display.");
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
