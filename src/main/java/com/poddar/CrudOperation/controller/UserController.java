package com.poddar.CrudOperation.controller;

import com.poddar.CrudOperation.mapper.ApiResponse;
import com.poddar.CrudOperation.mapper.UserRequest;
import com.poddar.CrudOperation.mapper.UserResponse;
import com.poddar.CrudOperation.model.UserRegs;
import com.poddar.CrudOperation.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    UserService userService;


    // http://localhost:8081/user/post
    @PostMapping("/post")
    public ResponseEntity<?> postUser(@RequestBody UserRequest userReq) {

        UserResponse userResponse = userService.postUserService(userReq);
        System.out.println(userResponse);
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setStatusCode(201);
        apiResponse.setMessage("Register successfully");
        apiResponse.setError(null);
        apiResponse.setResponse(userResponse);

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    // http://localhost:8081/user/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {

        List<UserRegs> userResponse =
                userService.getAllUser();

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setStatusCode(200);
        apiResponse.setMessage("User get Successfully");
        apiResponse.setError(null);
        apiResponse.setResponse(userResponse);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    // http://localhost:8081/user/1791220827482
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable("id") long id) {

        UserRegs userResponse = userService.getUserById(id);

        if (userResponse != null) {
            ApiResponse res = new ApiResponse();
            res.setStatusCode(200);
            res.setMessage("user get successfully");
            res.setError(null);
            res.setResponse(userResponse);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            ApiResponse res = new ApiResponse();
            res.setStatusCode(204);
            res.setMessage("user get successfully");
            res.setError(null);
            res.setResponse(userResponse);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }
}