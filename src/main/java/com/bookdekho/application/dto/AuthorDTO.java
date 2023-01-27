package com.bookdekho.application.dto;

import com.bookdekho.application.enums.Genre;
import com.bookdekho.application.enums.UserType;
import com.bookdekho.application.model.OnlineLinks;
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
public class AuthorDTO {

    private String id;

    @NotBlank(message = "Please enter user id")
    private String userId;

    @NotNull(message = "Please enter user type")
    private UserType userType;

    private Set<Genre> preferences;//book preference/genre of author

    private OnlineLinks onlineLinks;//online links like linkedIn, twitter

    private Set<String> authorImages; //set of author images urls

    private Set<String> aboutBooks; //reference of author published book

    private Set<String> bookReviewed; //reference of reviews by user

    private Long achievedPoints; //points received when community upvote your review
}
