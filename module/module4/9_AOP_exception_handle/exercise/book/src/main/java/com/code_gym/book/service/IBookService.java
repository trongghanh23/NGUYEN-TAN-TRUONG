package com.code_gym.book.service;

import com.code_gym.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Book getId(Integer id);
}
