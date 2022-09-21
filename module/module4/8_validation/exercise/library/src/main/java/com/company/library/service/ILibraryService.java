package com.company.library.service;


import com.company.library.model.Library;

import java.util.List;

public interface ILibraryService {
    List<Library> findAll();

    void save(Library library);

    void borrowBook(Integer id);

    void setQuantity(Integer id);
}