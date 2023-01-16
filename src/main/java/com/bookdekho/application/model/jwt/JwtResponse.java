package com.bookdekho.application.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;

}