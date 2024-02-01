package com.srinivas.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

    private final BookMarkRepository repository;

    @Transactional(readOnly = true)
    public List<BookMark> getAllBookMarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 2, Sort.Direction.DESC, "createdAt");
        return this.repository.findAll(pageable).getContent();
    }
}
