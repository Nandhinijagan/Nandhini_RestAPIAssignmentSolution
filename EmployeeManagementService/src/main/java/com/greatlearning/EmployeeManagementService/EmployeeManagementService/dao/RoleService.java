package com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Employee;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();
    public void save(Role role);
}
