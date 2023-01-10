package com.bookdekho.application.controller;

import com.bookdekho.application.dto.UserDTO;
import com.bookdekho.application.model.User;
import com.bookdekho.application.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController{

    @Autowired
    private UserService userService;
    private String USER_DELETED = "user deleted";

    @PostMapping(value = "/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        userDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO){
        userDTO = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping(value = "getUser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId){
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(name = "page")int page,
                                  @RequestParam(name = "size")int size){
        Page<User> users = userService.getAllUsers(page,size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUserById(userId);
        return new ResponseEntity(USER_DELETED, HttpStatus.OK);
    }
}
