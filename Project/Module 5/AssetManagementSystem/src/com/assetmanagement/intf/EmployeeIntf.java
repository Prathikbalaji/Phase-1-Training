package com.assetmanagement.intf;

import com.assetmanagement.models.Employee;
import java.util.List;

public interface EmployeeIntf {
    void addEmployee(Employee employee);
    void removeEmployee(int employeeID);
    void updateEmployee(Employee employee);
    Employee getEmployee(int employeeID);
    List<Employee> getAllEmployees();
}
