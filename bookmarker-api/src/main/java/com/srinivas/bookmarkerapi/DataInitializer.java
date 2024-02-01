package com.srinivas.bookmarkerapi;

import com.srinivas.bookmarkerapi.domain.BookMark;
import com.srinivas.bookmarkerapi.domain.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookMarkRepository bookMarkRepository;

    @Override
    public void run(String... args) throws Exception {
        this.bookMarkRepository.save(new BookMark(null, "Srinivas", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas1", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas2", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas3", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas4", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas5", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas6", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas7", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas9", "www.google.com", Instant.now()));
        this.bookMarkRepository.save(new BookMark(null, "Srinivas10", "www.google.com", Instant.now()));
    }
}
