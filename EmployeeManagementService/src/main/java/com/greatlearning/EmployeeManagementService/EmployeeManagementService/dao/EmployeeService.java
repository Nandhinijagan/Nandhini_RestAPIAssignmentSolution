package com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao;


import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(int employeeId);
    void deleteById(int id);
    List<Employee> findAllByOrderByFirstNameAsc();
    List<Employee> findAllByOrderByFirstNameDesc();
    List<Employee> findByFirstName(String firstName);
}
