package com.srinivas.bookmarkerapi.api;

import com.srinivas.bookmarkerapi.domain.BookMark;
import com.srinivas.bookmarkerapi.domain.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @GetMapping
    public List<BookMark> getBookMarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return this.bookMarkService.getAllBookMarks(page);
    }
}
