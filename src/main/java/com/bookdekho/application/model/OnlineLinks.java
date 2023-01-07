package com.bookdekho.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class OnlineLinks {
    @Id
    private String id;

    private String linkedInUrl;
    private String twitterUrl;
    private String pinterestUrl;
    private String instagramUrl;
    private String kindleUrl;
    private String exhibitionUrl;

}
