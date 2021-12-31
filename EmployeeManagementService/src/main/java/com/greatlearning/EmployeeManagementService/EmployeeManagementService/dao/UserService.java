package com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User save(User user);
}
