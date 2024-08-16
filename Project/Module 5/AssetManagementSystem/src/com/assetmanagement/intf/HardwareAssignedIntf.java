package com.assetmanagement.intf;

import com.assetmanagement.models.HardwareAssigned;
import java.util.List;

public interface HardwareAssignedIntf {
    void addHardwareAssigned(HardwareAssigned assigned);
    void removeHardwareAssigned(int assignedID);
    void updateHardwareAssigned(HardwareAssigned assigned);
    HardwareAssigned getHardwareAssigned(int assignedID);
    List<HardwareAssigned> getAllHardwareAssigned();
}
