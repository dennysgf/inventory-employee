package com.dennys.inventory.controller;

import com.dennys.inventory.dto.Login;
import com.dennys.inventory.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthUserService authUserService;

    @PostMapping
    public String login(@RequestBody Login login){
        if(!authUserService.findExistByUserName(login.getUserName())){
            throw new NotFoundException("User no found");
        };
        return authUserService.validPassword(login.getUserName(),login.getPassword());
    }

}
