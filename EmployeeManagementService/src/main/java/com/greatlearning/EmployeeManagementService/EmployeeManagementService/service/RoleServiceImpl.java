package com.greatlearning.EmployeeManagementService.EmployeeManagementService.service;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao.RoleService;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Role;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo.EmployeeRepository;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
