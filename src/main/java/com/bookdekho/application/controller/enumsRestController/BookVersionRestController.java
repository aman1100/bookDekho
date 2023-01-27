package com.bookdekho.application.controller.enumsRestController;

import com.bookdekho.application.enums.BookVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookVersion")
public class BookVersionRestController {

    @GetMapping
    public Object[] geBookVersion(){
        return BookVersion.class.getEnumConstants();
    }
}
