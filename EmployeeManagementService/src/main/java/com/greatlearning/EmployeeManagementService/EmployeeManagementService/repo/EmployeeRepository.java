package com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo;


import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByFirstNameAsc();


    List<Employee> findAllByOrderByFirstNameDesc();

    List<Employee> findByFirstName(String firstName);
}
