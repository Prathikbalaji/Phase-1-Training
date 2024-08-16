package com.assetmanagement.models;

public class Admin {
    private int adminID;
    private String adminName;

    public Admin(int adminID, String adminName) {
        this.adminID = adminID;
        this.adminName = adminName;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
