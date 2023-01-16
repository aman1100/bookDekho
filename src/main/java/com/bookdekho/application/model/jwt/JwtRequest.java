package com.bookdekho.application.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1321231232133123L;

    private String username;
    private String password;

}
