package com.assetmanagement.impl;

import com.assetmanagement.models.HardwareAssigned;
import com.assetmanagement.repository.HardwareAssignedRepository;
import com.assetmanagement.intf.HardwareAssignedIntf;

import java.util.List;

public class HardwareAssignedImpl implements HardwareAssignedIntf {
    private HardwareAssignedRepository hardwareAssignedRepo;

    public HardwareAssignedImpl(HardwareAssignedRepository hardwareAssignedRepo) {
        this.hardwareAssignedRepo = hardwareAssignedRepo;
    }

    @Override
    public void addHardwareAssigned(HardwareAssigned assigned) {
        hardwareAssignedRepo.addHardwareAssigned(assigned);
    }

    @Override
    public void removeHardwareAssigned(int assignedID) {
        hardwareAssignedRepo.removeHardwareAssigned(assignedID);
    }

    @Override
    public void updateHardwareAssigned(HardwareAssigned assigned) {
        hardwareAssignedRepo.updateHardwareAssigned(assigned);
    }

    @Override
    public HardwareAssigned getHardwareAssigned(int assignedID) {
        return hardwareAssignedRepo.getHardwareAssigned(assignedID);
    }

    @Override
    public List<HardwareAssigned> getAllHardwareAssigned() {
        return hardwareAssignedRepo.getAllHardwareAssigned();
    }
}
