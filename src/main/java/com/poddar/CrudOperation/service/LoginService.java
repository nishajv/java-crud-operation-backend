package com.poddar.CrudOperation.service;

import com.poddar.CrudOperation.mapper.LoginRequest;
import com.poddar.CrudOperation.model.UserRegs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    public Boolean LoginMethodService(LoginRequest loginRequest) {

        //loginRequest form data
        long id = loginRequest.getId();
        String pwd = loginRequest.getPassword();

        //Db store login data
        Optional<UserRegs> userResponse = userService.getUserById(id);
        if (userResponse.isPresent()) {

            if (id == userResponse.get().getId() && pwd.equals(userResponse.get().getPassword())) {
                return true;
            }else{
                return false;
            }

            }else{
            return false;

        }
    }
}