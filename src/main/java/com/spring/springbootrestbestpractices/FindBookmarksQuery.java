package com.spring.springbootrestbestpractices;

// Wrapper class for the query parameters of the findBookmarks method in the BookmarkService class
public record FindBookmarksQuery(
        int pageNumber,
        int pageSize) {
}
