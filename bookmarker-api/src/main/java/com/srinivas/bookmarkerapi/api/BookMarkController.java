package com.srinivas.bookmarkerapi.api;

import com.srinivas.bookmarkerapi.domain.BookmarkService;
import com.srinivas.bookmarkerapi.domain.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookMarkController {
    private final BookmarkService bookMarkService;

    @GetMapping
    public BookmarksDTO getBookMarks(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return this.bookMarkService.getAllBookMarks(page, pageSize);
    }
}
