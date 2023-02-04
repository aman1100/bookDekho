package com.bookdekho.application.dto;

import com.bookdekho.application.enums.BookVersion;
import com.bookdekho.application.enums.Genre;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReviewDTO {

    private String id;

    @NotBlank(message = "Please enter aboutBook Id")
    private String aboutBookId; //reference of about book model

    @NotBlank(message = "Please enter Book Name")
    private String bookName;

    @NotBlank(message = "Please enter Genre")
    private Genre genre;

    @NotBlank(message = "Please enter Author Name")
    private String authorName;

    @NotBlank(message = "Please enter author Id")
    private String userId;//reference of author

    @NotEmpty
    @NotBlank
    @Size(min = 20, message = "Review should contain 20 characters")
    private String review; //book review

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Max(value = 5,message = "review should be in 1 to 5")
    @Min(value = 1,message = "review should be in 1 to 5")
    private Integer reviewInStars;

//    private Integer preferredAge; //optional

    private String authorReview;//optional

    private BookVersion bookVersion;//optional

    @NotEmpty
    @NotBlank(message = "Please provide review Date")
    private Instant reviewDate;
}
