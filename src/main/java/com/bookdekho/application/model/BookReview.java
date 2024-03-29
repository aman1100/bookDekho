package com.bookdekho.application.model;

import com.bookdekho.application.enums.BookVersion;
import com.bookdekho.application.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReview {
    @Id
    private String id;
    private String aboutBookId; //reference of about book model
    private String bookName;//auto-populate from registered book
    private Genre genre;//auto-populate from registered book
    private String authorName;//auto-populate from registered book
    private String userId;
    private String review; //book review
    private Integer reviewInStars;
//    private Integer preferredAge;
    private String authorReview;
    private BookVersion bookVersion;
    private Instant reviewDate;

}
