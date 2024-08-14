package com.assetmanagement.intf;

import com.assetmanagement.models.HardwareAsset;
import java.util.List;

public interface HardwareAssetIntf {
    void addHardwareAsset(HardwareAsset asset);
    void removeHardwareAsset(int assetID);
    void updateHardwareAsset(HardwareAsset asset);
    HardwareAsset getHardwareAsset(int assetID);
    List<HardwareAsset> getAllHardwareAssets();
}
