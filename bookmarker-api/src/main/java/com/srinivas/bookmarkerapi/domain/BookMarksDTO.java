package com.srinivas.bookmarkerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookMarksDTO {
    private List<BookMark> data;
    private long totalElement;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrev;

    public BookMarksDTO(Page<BookMark> bookMarksPage) {
        this.setData(bookMarksPage.getContent());
        this.setTotalElement(bookMarksPage.getTotalElements());
        this.setTotalPages(bookMarksPage.getTotalPages());
        this.setCurrentPage(bookMarksPage.getNumber() + 1);
        this.setFirst(bookMarksPage.isFirst());
        this.setLast(bookMarksPage.isLast());
        this.setHasNext(bookMarksPage.hasNext());
        this.setHasPrev(bookMarksPage.hasPrevious());
    }
}
