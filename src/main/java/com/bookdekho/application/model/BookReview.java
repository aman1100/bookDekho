package com.bookdekho.application.model;

import com.bookdekho.application.enums.BookVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@AllArgsConstructor
public class BookReview {
    @Id
    private String id;
    private String aboutBookId; //reference of about book model
    private String review; //book review
    private Integer reviewInStars;
    private Integer preferredAge;
    private String authorReview;
    private BookVersion bookVersion;
    private Instant reviewDate;

}
