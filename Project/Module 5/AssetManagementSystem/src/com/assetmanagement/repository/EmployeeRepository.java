package com.assetmanagement.repository;

import com.assetmanagement.models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeID(), employee);
    }

    public void removeEmployee(int employeeID) {
        employeeMap.remove(employeeID);
    }

    public void updateEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeID(), employee);
    }

    public Employee getEmployee(int employeeID) {
        return employeeMap.get(employeeID);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }
}
