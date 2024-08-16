package com.assetmanagement.models;

import java.time.LocalDate;
import java.util.Date;

public class HardwareAsset {
    private int hardwareAssetID;
    private String assetName;
    private String assetType;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private int warrantyPeriod;
    private String assetStatus;

    public HardwareAsset(int hardwareAssetID, String assetName, String assetType, LocalDate purchaseDate, double purchasePrice, int warrantyPeriod, String assetStatus) {
        this.hardwareAssetID = hardwareAssetID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.warrantyPeriod = warrantyPeriod;
        this.assetStatus = assetStatus;
    }

    public int getHardwareAssetID() {
        return hardwareAssetID;
    }

    public void setHardwareAssetID(int hardwareAssetID) {
        this.hardwareAssetID = hardwareAssetID;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    @Override
    public String toString() {
        return "HardwareAsset{" +
                "hardwareAssetID=" + hardwareAssetID +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", warrantyPeriod=" + warrantyPeriod +
                ", assetStatus='" + assetStatus + '\'' +
                '}';
    }
}
