package com.bookdekho.application.dto;

import com.bookdekho.application.enums.BookVersion;
import com.bookdekho.application.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@Validated
public class AboutBookDTO {

    @NotBlank(message = "Please enter author Id")
    private String authorId;

    @NotEmpty
    @Size(min = 1, message = "Please provide atleast one book cover")
    private Set<String> bookCoverUrl;//set of book cover images

    private Set<String> authorImages;//set of author images urls , optional

    @NotEmpty
    @Size(min = 2, message = "Book name should have at least 2 characters")
    private String bookName;

    @NotEmpty
    @Size(min = 2, message = "Book name should have at least 2 characters")
    private String bookTitle;

    @NotNull(message = "Please provide book genre")
    private Genre bookGenre;

    @NotNull(message = "Please provide book version")
    private BookVersion bookVersion;

    @NotEmpty
    @Size(min = 2, message = "Author name should have at least 2 characters")
    private String authorName;

    @NotEmpty
    @Size(min = 20, message = "Book description should have at least 20 characters")
    private String bookDescription;

    @NotNull
    private Instant publishedDate;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer preferredAge;

    private Set<String> availability;//optional

    @NotEmpty
    @Size(min = 2, message = "Publishers should have at least 20 characters")
    private String publishers;

    private Instant createdDate;
}
