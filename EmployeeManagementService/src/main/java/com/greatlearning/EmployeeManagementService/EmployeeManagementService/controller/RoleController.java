package com.greatlearning.EmployeeManagementService.EmployeeManagementService.controller;


import com.greatlearning.EmployeeManagementService.EmployeeManagementService.dao.RoleService;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
//        (value="/roles", method = {RequestMethod.GET, RequestMethod.POST})
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<Role> listEmployee() {
        // get roles from db
        List<Role> roles = roleService.findAll();
        System.out.println(roles);
        return roles;
    }

    @PostMapping("/save")
//    public String save(@RequestParam("role_id") int role_id , @RequestParam("name") String name) {
    public Role save(@RequestBody Role role) {
//        role.setId(0);
        roleService.save(role);
        return role;

    }
}
