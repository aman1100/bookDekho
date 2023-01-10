package com.bookdekho.application.model;

import com.bookdekho.application.enums.Genre;
import com.bookdekho.application.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    @Id
    private String id;

    private UserType userType;
    private Set<Genre> preferences;//reader book preference/genre
    private Set<String> bookReviewed;//reference of reviews by user
    private Long achievedPoints; //points received when community upvote your review
}
