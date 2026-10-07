package com.poddar.CrudOperation.controller;

import com.poddar.CrudOperation.mapper.ApiResponse;
import com.poddar.CrudOperation.mapper.LoginRequest;

import com.poddar.CrudOperation.service.LoginService;
i
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            //DELETE PROFILE
                //http://localhost:8080/login/delete
                @PatchMapping("/delete/{id}")
                        public ResponseEntity<?> deleteUserProfile(@PathVariable long id){
                    boolean deleteResult=loginService.LoginMethodService(id);
                    if(deleteResult==true){
                        ApiResponse res = new ApiResponse();
                        res.setStatusCode(200);
                        res.setMessage("Delete successfully");
                        res.setError(null);
                        res.setResponse("delete");
                        return new ResponseEntity<>(res, HttpStatus.OK);
                    } else {
                        ApiResponse res = new ApiResponse();
                        res.setStatusCode(200);
                        res.setMessage("Data Not Found");
                        res.setError(null);
                        res.setResponse("NULL");
                        return new ResponseEntity<>(res, HttpStatus.OK);
                    }
                }
            }
        }
    }

