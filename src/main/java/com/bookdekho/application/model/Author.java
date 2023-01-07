package com.bookdekho.application.model;

import com.bookdekho.application.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@AllArgsConstructor
public class Author {
    @Id
    private String id;

    private UserType userType;
    private Set<String> preferences;//book preference/genre of author
    private OnlineLinks onlineLinks;//online links like linkedIn, twitter
    private Set<String> authorImages; //set of author images urls
    private Set<String> aboutBooks; //reference of author published book
    private Set<String> bookReviewed; //reference of reviews by user
    private Long achievedPoints; //points received when community upvote your review
}
