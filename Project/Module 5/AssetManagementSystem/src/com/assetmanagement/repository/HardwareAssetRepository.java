package com.assetmanagement.repository;

import com.assetmanagement.models.HardwareAsset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardwareAssetRepository {
    private Map<Integer, HardwareAsset> hardwareAssetMap = new HashMap<>();

    public void addHardwareAsset(HardwareAsset asset) {
        hardwareAssetMap.put(asset.getHardwareAssetID(), asset);
    }

    public void removeHardwareAsset(int assetID) {
        hardwareAssetMap.remove(assetID);
    }

    public void updateHardwareAsset(HardwareAsset asset) {
        hardwareAssetMap.put(asset.getHardwareAssetID(), asset);
    }

    public HardwareAsset getHardwareAsset(int assetID) {
        return hardwareAssetMap.get(assetID);
    }

    public List<HardwareAsset> getAllHardwareAssets() {
        return new ArrayList<>(hardwareAssetMap.values());
    }
}
