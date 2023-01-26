package com.bookdekho.application.controller;

import com.bookdekho.application.model.LoginDTO;
import com.bookdekho.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginRestController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        String response =  userService.authenticateUser(loginDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
