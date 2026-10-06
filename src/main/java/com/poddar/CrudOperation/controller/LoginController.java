package com.poddar.CrudOperation.controller;

import com.poddar.CrudOperation.mapper.ApiResponse;
import com.poddar.CrudOperation.mapper.LoginRequest;
//import com.poddar.CrudOperation.mapper.UserRequest;
import com.poddar.CrudOperation.service.LoginService;
//import com.poddar.CrudOperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")

public class LoginController {

    //http://8080/crud/login
    @Autowired
    LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        boolean loginResult = loginService.LoginMethodService(loginRequest);

            if (loginResult == true) {
                ApiResponse res = new ApiResponse();
                res.setStatusCode(200);
                res.setMessage("Login successfully");
                res.setError(null);
                res.setResponse("Login");
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                ApiResponse res = new ApiResponse();
               res.setStatusCode(401);
                res.setMessage("Invalid Credential");
                res.setError(null);
                res.setResponse("Invalid Login");
                return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
            }
        }
    }

