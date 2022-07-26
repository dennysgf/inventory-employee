package com.dennys.inventory.controller;

import com.dennys.inventory.entity.AuthUser;
import com.dennys.inventory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUserController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public AuthUser create(@RequestBody AuthUser authUser) {
        return employeeService.insertUser(authUser);
    }
}
