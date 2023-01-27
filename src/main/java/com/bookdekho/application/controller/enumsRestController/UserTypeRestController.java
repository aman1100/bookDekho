package com.bookdekho.application.controller.enumsRestController;

import com.bookdekho.application.enums.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userType")
public class UserTypeRestController {

    @GetMapping
    public Object[] getUserType(){
        return UserType.class.getEnumConstants();
    }
}
