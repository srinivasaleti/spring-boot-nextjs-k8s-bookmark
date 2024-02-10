package com.srinivas.bookmarkerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarksDTO {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkDTO> bookMarksPage) {
        this.setData(bookMarksPage.getContent());
        this.setTotalElements(bookMarksPage.getTotalElements());
        this.setTotalPages(bookMarksPage.getTotalPages());
        this.setCurrentPage(bookMarksPage.getNumber() + 1);
        this.setFirst(bookMarksPage.isFirst());
        this.setLast(bookMarksPage.isLast());
        this.setHasNext(bookMarksPage.hasNext());
        this.setHasPrevious(bookMarksPage.hasPrevious());
    }
}
