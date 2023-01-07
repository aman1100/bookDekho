package com.bookdekho.application.model;

import com.bookdekho.application.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
public class AboutBook {
    @Id
    private String id;

    private String authorId;
    private Set<String> bookCoverUrl;//set of book cover images
    private Set<String> authorImages;//set of author images urls
    private String bookName;
    private String bookTitle;
    private Genre bookGenre;
    private BookVersion bookVersion;
    private String authorName;
    private String bookDescription;
    private Instant publishedDate;
    private Integer preferredAge;
    private Set<String> availability;
    private String publishers;
    private Instant createdDate;


}
