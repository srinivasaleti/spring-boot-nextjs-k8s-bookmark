package com.srinivas.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

    private final BookMarkRepository repository;

    @Transactional(readOnly = true)
    public BookMarksDTO getAllBookMarks(Integer page, Integer pageSize) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "createdAt");
        return new BookMarksDTO(this.repository.findAll(pageable));
    }
}
