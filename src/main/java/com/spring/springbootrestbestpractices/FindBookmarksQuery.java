package com.spring.springbootrestbestpractices;

public record FindBookmarksQuery(
        int pageNumber,
        int pageSize) {
}
