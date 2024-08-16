package com.assetmanagement.repository;

import com.assetmanagement.models.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository {
    private Map<Integer, Admin> adminMap = new HashMap<>(); 
    
    public void addAdmin(Admin admin) {
        adminMap.put(admin.getAdminID(), admin);
    }

    public void removeAdmin(int adminID) {
        adminMap.remove(adminID);
    }

    public void updateAdmin(Admin admin) {
        adminMap.put(admin.getAdminID(), admin);
    }

    public Admin getAdmin(int adminID) {
        return adminMap.get(adminID);
    }

    public List<Admin> getAllAdmins() {
        return new ArrayList<>(adminMap.values());
    }
}
