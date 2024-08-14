package com.assetmanagement.impl;

import com.assetmanagement.models.Employee;
import com.assetmanagement.repository.EmployeeRepository;
import com.assetmanagement.intf.EmployeeIntf;

import java.util.List;

public class EmployeeImpl implements EmployeeIntf {
    private EmployeeRepository employeeRepo;

    public EmployeeImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepo.addEmployee(employee);
    }

    @Override
    public void removeEmployee(int employeeID) {
        employeeRepo.removeEmployee(employeeID);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.updateEmployee(employee);
    }

    @Override
    public Employee getEmployee(int employeeID) {
        return employeeRepo.getEmployee(employeeID);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }
}
