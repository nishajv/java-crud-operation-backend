package com.poddar.CrudOperation.controller;


import com.poddar.CrudOperation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> getHelloMethod() {

        String str = testService.printName();

        Map<String, String> apiRes = new HashMap<>();
        apiRes.put("Name", str);

        return new ResponseEntity<>(apiRes, HttpStatus.OK);
    }


    }


