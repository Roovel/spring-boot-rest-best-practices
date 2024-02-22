package com.spring.springbootrestbestpractices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// Wrapper class for the paged result of a query method in the service layer
public record PagedResult<T>(
        List<T> data,
        long totalElements,
        int pageNumber,
        int totalPages,
        @JsonProperty("isFirst") boolean isFirst,
        @JsonProperty("isLast") boolean isLast,
        @JsonProperty("hasNext") boolean hasNext,
        @JsonProperty("hasPrevious") boolean hasPrevious) {
}
