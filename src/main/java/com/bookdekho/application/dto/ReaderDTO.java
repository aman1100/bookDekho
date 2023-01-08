package com.bookdekho.application.dto;

import com.bookdekho.application.enums.Genre;
import com.bookdekho.application.enums.UserType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ReaderDTO {

    @NotNull(message = "Please enter user type")
    private UserType userType;

    @Size(min = 1, message = "Please provide atleast one preference")
    private Set<Genre> preferences;//reader book preference/genre
    private Set<String> bookReviewed;//reference of reviews by user
    private Long achievedPoints; //points received when community upvote your review
}
