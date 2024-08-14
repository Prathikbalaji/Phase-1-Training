package com.assetmanagement.models;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String email;
    private String phoneNumber;
    private String designation;

    public Employee(int employeeID, String employeeName, String email, String phoneNumber, String designation) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
