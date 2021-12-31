package com.greatlearning.EmployeeManagementService.EmployeeManagementService.service;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao.EmployeeService;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Employee;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeRepository.getById(employeeId);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByOrderByFirstNameAsc() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public List<Employee> findAllByOrderByFirstNameDesc() {
        return employeeRepository.findAllByOrderByFirstNameDesc();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

}
