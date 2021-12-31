package com.greatlearning.EmployeeManagementService.EmployeeManagementService.controller;


import com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao.UserService;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Role;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value="/users", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> listEmployee() {
        // get roles from db
        List<User> users = userService.findAll();
        System.out.println(users);
        return users;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        user.setId(0l);
        return userService.save(user);
    }
}
