package com.bookdekho.application.controller;

import com.bookdekho.application.dto.UserDTO;
import com.bookdekho.application.model.User;
import com.bookdekho.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController{

    @Autowired
    private UserService userService;
    private static final String USER_DELETED = "user Deleted";

    @PostMapping(value = "/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        userDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO){
        userDTO = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "getUser/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId){
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(name = "page")int page,
                                  @RequestParam(name = "size")int size){
        Page<User> users = userService.getAllUsers(page,size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(USER_DELETED);
    }

    @GetMapping(value = "/checkUserExists/{email}")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable String email){
        Boolean userExists = userService.checkUserExists(email);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }
}
