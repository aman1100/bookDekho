package com.bookdekho.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldRestController {

    @GetMapping
    public String firstPage(){
        return "Hello World";
    }
}
