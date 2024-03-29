package com.bookdekho.application.dto;

import com.bookdekho.application.enums.Genre;
import com.bookdekho.application.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDTO {

    private String id;

    @NotBlank(message = "Please enter user id")
    private String userId;
    @NotNull(message = "Please enter user type")
    private UserType userType;

    @Size(min = 1, message = "Please provide at least one preference")
    private Set<Genre> preferences;//reader book preference/genre
    private Set<String> bookReviewed;//reference of reviews by user
    private Long achievedPoints; //points received when community upvote your review
}
