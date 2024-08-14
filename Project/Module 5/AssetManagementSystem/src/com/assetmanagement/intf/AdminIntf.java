package com.assetmanagement.intf;

import com.assetmanagement.models.Admin;
import java.util.List;

public interface AdminIntf {
    void addAdmin(Admin admin);
    void removeAdmin(int adminID);
    void updateAdmin(Admin admin);
    Admin getAdmin(int adminID);
    List<Admin> getAllAdmins();
}
