package com.bookdekho.application.model;

import com.bookdekho.application.enums.BookVersion;
import com.bookdekho.application.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchParameters {

    private String bookName;
    private List<Genre> genre;
    private Integer star;
    private List<BookVersion> bookVersions;
    private String authorName;
}
