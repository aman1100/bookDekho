package com.bookdekho.application.dto;

import com.bookdekho.application.enums.UserType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String prefix;

    @NotEmpty
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;

    private String middleName;

    @NotEmpty
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lastName;

    @NotNull(message="Please enter your Age")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer age;

    @NotNull(message="Please enter user type")
    private UserType userType;

    @NotEmpty
    @NotBlank(message="Please enter your email")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    private String phoneNumber;
    private String authorId;
    private String readerId;
}
