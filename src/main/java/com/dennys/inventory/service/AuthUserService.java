package com.dennys.inventory.service;

import com.dennys.inventory.entity.AuthUser;
import com.dennys.inventory.errors.EntityNotFoundException;
import com.dennys.inventory.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    AuthUserRepository authUSer;

    public Boolean findExistByUserName(String userName){
        return authUSer.existsByUserName(userName);
    }

    public String validPassword(String userName, String password){
        Optional<AuthUser> authUser =  authUSer.findByUserName(userName);
        AuthUser user = authUSer.findByUserName(userName).orElseThrow(() -> new EntityNotFoundException(AuthUser.class, "userName", "fail"));
        if(!user.getPassword().equals(password)){
            throw new InternalError("Password no correct");
        }
        return "user access";
    }
}
