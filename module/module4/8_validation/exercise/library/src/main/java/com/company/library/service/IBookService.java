package com.company.library.service;

import com.company.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void setStatus(Integer id);

    void returnBook(Integer bookCode) throws Exception;
}
