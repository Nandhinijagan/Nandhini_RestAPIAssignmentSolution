package com.greatlearning.EmployeeManagementService.EmployeeManagementService.service;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao.UserService;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.User;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
      return userRepository.save(user);
    }
}
