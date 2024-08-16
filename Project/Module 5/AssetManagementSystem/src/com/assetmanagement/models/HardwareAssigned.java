package com.assetmanagement.models;

import java.time.LocalDate;
import java.util.Date;

public class HardwareAssigned {
    private int hardwareAssignedID;
    private int hardwareAssetID;
    private int employeeID;
    private String assignedBy;
    private LocalDate assignedDate;
    private String assignedStatus;

    public HardwareAssigned(int hardwareAssignedID, int hardwareAssetID, int employeeID, String assignedBy, LocalDate assignedDate, String assignedStatus) {
        this.hardwareAssignedID = hardwareAssignedID;
        this.hardwareAssetID = hardwareAssetID;
        this.employeeID = employeeID;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
        this.assignedStatus = assignedStatus;
    }

    public int getHardwareAssignedID() {
        return hardwareAssignedID;
    }

    public void setHardwareAssignedID(int hardwareAssignedID) {
        this.hardwareAssignedID = hardwareAssignedID;
    }

    public int getHardwareAssetID() {
        return hardwareAssetID;
    }

    public void setHardwareAssetID(int hardwareAssetID) {
        this.hardwareAssetID = hardwareAssetID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(String assignedStatus) {
        this.assignedStatus = assignedStatus;
    }

    @Override
    public String toString() {
        return "HardwareAssigned{" +
                "hardwareAssignedID=" + hardwareAssignedID +
                ", hardwareAssetID=" + hardwareAssetID +
                ", employeeID=" + employeeID +
                ", assignedBy='" + assignedBy + '\'' +
                ", assignedDate=" + assignedDate +
                ", assignedStatus='" + assignedStatus + '\'' +
                '}';
    }
}
