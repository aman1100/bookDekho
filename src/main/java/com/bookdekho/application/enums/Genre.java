package com.bookdekho.application.enums;

public enum Genre {
    LITERARY_FICTION("Literary Fiction"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    HORROR("Horror"),
    HISTORICAL("Historical"),
    Romance("Romance"),
    WESTERN("Western"),
    BILDUNGSROMAN("Bildungsroman"),
    SPECULATIVE_FICTION("Speculative Fiction"),
    SCIENCE_FICTION("Science Fiction"),
    FANTASY("Fantasy"),
    DYSTOPIAN("Dystopian"),
    MAGICAL_REALISM("Magical Realism"),
    REALIST_LITERATURE("Realist Literature");




    private final String searchParameter;
//    private final String description;

    Genre(String searchParameter){
        this.searchParameter = searchParameter;
    }
    public String getSearchParameter(){return searchParameter;}
}
