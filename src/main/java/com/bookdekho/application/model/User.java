package com.bookdekho.application.model;

import com.bookdekho.application.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private UserType userType;
    private String email;
    private String phoneNumber;
    private String authorId;
    private String readerId;
}
