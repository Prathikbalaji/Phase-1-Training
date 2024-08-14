package com.assetmanagement.repository;

import com.assetmanagement.models.HardwareAssigned;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardwareAssignedRepository {
    private Map<Integer, HardwareAssigned> hardwareAssignedMap = new HashMap<>();

    public void addHardwareAssigned(HardwareAssigned assigned) {
        hardwareAssignedMap.put(assigned.getHardwareAssignedID(), assigned);
    }

    public void removeHardwareAssigned(int assignedID) {
        hardwareAssignedMap.remove(assignedID);
    }

    public void updateHardwareAssigned(HardwareAssigned assigned) {
        hardwareAssignedMap.put(assigned.getHardwareAssignedID(), assigned);
    }

    public HardwareAssigned getHardwareAssigned(int assignedID) {
        return hardwareAssignedMap.get(assignedID);
    }

    public List<HardwareAssigned> getAllHardwareAssigned() {
        return new ArrayList<>(hardwareAssignedMap.values());
    }
}
