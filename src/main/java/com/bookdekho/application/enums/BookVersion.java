package com.bookdekho.application.enums;

public enum BookVersion {

    FIRST_EDITION("First edition"),
    BIBLIOGRAPHICAL_DEFINITION("Bibliographical definition"),
    COLLECTORS_DEFINITION("Collectors' definition"),
    PUBLISHERS_DEFINITION("Publishers' definitions"),
    REVISED_EDITION("Revised edition"),
    REVISED_AND_UPDATED_EDITION("Revised and updated edition"),
    CO_EDITION("Co-edition"),
    E_DITION("e-dition"),
    LIBRARY_EDITION("Library edition"),
    BOOK_CLUB_EDITION("Book club edition"),
    CHEAP_EDITION("Cheap edition"),
    COLONIAL_EDITION("Colonial edition"),
    CADET_EDITION("Cadet edition"),
    LARGE_PRINT_EDITION("Large print edition"),
    CRITICAL_EDITION("Critical edition"),
    NUMBERING("Numbering"),
    REPUBLICATION("Republication"),
    LEGAL_STATUS("Legal status"),
    SEE_ALSO("See also"),
    NOTES("Notes"),
    REFERENCES("References"),
    BIBLIOGRAPHY("Bibliography");





    private final String searchParameter;

    BookVersion(String searchParameter) {
        this.searchParameter = searchParameter;
    }
    public String getSearchParameter(){return searchParameter;}
}
