package com.assetmanagement.impl;

import com.assetmanagement.models.Admin;
import com.assetmanagement.repository.AdminRepository;
import com.assetmanagement.intf.AdminIntf;

import java.util.List;

public class AdminImpl implements AdminIntf {
    private AdminRepository adminRepo;

    public AdminImpl(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepo.addAdmin(admin);
    }

    @Override
    public void removeAdmin(int adminID) {
        adminRepo.removeAdmin(adminID);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepo.updateAdmin(admin);
    }

    @Override
    public Admin getAdmin(int adminID) {
        return adminRepo.getAdmin(adminID);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.getAllAdmins();
    }
}
