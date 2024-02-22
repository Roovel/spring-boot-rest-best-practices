package com.spring.springbootrestbestpractices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    // Retrieves a list of bookmarks from the database and returns them as a PagedResult which contains the list of bookmarks and some metadata
    public PagedResult<BookmarkDTO> findBookmarks(FindBookmarksQuery query) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        // Spring Data JPA uses 0-based page numbers which is why we subtract 1 from the query parameter
        int pageNumber = query.pageNumber() > 0 ? query.pageNumber() - 1 : 0;
        Pageable pageable = PageRequest.of(pageNumber, query.pageSize(), sort);
        Page<BookmarkDTO> page = bookmarkRepository.findBookmarks(pageable);

        return new PagedResult<>(
                page.getContent(),
                page.getTotalElements(),
                page.getNumber() + 1, // Same here, we add 1 to the 0-based page number
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious()
        );
    }
}
