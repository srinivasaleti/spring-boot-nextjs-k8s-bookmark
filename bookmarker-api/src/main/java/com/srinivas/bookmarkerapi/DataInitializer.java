package com.srinivas.bookmarkerapi;

import com.srinivas.bookmarkerapi.domain.Bookmark;
import com.srinivas.bookmarkerapi.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookMarkRepository;

    @Override
    public void run(String... args) throws Exception {
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas1", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas2", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas3", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas4", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas5", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas6", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas7", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas9", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new Bookmark(null, "Srinivas10", "www.google.com", Instant.now()));
    }
}
