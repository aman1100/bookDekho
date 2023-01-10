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
public class Author {
    @Id
    private String id;

    private UserType userType;
    private Set<Genre> preferences;//book preference/genre of author
    private OnlineLinks onlineLinks;//online links like linkedIn, twitter
    private Set<String> authorImages; //set of author images urls
    private String primaryImageUrl;
    private Set<String> aboutBooks; //reference of author published book
    private Set<String> bookReviewed; //reference of reviews by user
    private Long achievedPoints; //points received when community upvote your review
}
