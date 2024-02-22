package com.spring.springbootrestbestpractices;

import java.time.Instant;

// Data Transfer Object (DTO) for the Bookmark entity
public record BookmarkDTO(
        Long id,
        String title,
        String url,
        Instant createdAt) {
}
