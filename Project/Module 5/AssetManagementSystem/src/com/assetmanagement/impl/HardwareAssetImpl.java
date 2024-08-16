package com.assetmanagement.impl;

import com.assetmanagement.models.HardwareAsset;
import com.assetmanagement.repository.HardwareAssetRepository;
import com.assetmanagement.intf.HardwareAssetIntf;

import java.util.List;

public class HardwareAssetImpl implements HardwareAssetIntf {
    private HardwareAssetRepository hardwareAssetRepo;

    public HardwareAssetImpl(HardwareAssetRepository hardwareAssetRepo) {
        this.hardwareAssetRepo = hardwareAssetRepo;
    }

    @Override
    public void addHardwareAsset(HardwareAsset asset) {
        hardwareAssetRepo.addHardwareAsset(asset);
    }

    @Override
    public void removeHardwareAsset(int assetID) {
        hardwareAssetRepo.removeHardwareAsset(assetID);
    }

    @Override
    public void updateHardwareAsset(HardwareAsset asset) {
        hardwareAssetRepo.updateHardwareAsset(asset);
    }

    @Override
    public HardwareAsset getHardwareAsset(int assetID) {
        return hardwareAssetRepo.getHardwareAsset(assetID);
    }

    @Override
    public List<HardwareAsset> getAllHardwareAssets() {
        return hardwareAssetRepo.getAllHardwareAssets();
    }
}
