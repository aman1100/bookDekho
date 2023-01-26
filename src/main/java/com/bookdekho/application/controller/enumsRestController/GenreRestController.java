package com.bookdekho.application.controller.enumsRestController;

import com.bookdekho.application.enums.Genre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/genre")
public class GenreRestController {

    @GetMapping
    public Map<Genre, String> getGenres(){
        Map<Genre, String> genreWithDescription = new HashMap<>();
        for(Genre genre : Genre.values()){
            genreWithDescription.put(genre, genre.getDescription());
        }
        return genreWithDescription;
    }
}
