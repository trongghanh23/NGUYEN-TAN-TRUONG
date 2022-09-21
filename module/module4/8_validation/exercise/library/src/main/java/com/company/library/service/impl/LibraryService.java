package com.company.library.service.impl;


import com.company.library.model.Book;
import com.company.library.model.Library;
import com.company.library.repository.IBookRepository;
import com.company.library.repository.ILibraryRepository;
import com.company.library.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private ILibraryRepository iLibraryRepository;

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Library> findAll() {
        return this.iLibraryRepository.findAll();
    }

    @Override
    public void save(Library library) {
        this.iLibraryRepository.save(library);
    }

    @Override
    public void borrowBook(Integer id) {
        Library library = this.iLibraryRepository.getById(id);
        if (!checkBookExists(library, this.iBookRepository.findAll())) {
            for (int i = 0; i < library.getQuantity(); i++) {
                List<Book> books = this.iBookRepository.findAll();
                Book book = new Book();
                book.setBookCode(getRandomNumber(books));
                book.setStatus(false);
                book.setLibrary(library);
                this.iBookRepository.save(book);
            }
        }
    }

    @Override
    public void setQuantity(Integer id) {
        this.iLibraryRepository.setQuantity(this.iBookRepository.getById(id).getLibrary().getId());
    }

    private boolean checkBookExists(Library library, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getLibrary().equals(library)) {
                return true;
            }
        }
        return false;
    }

    private int getRandomNumber(List<Book> bookList) {
        int randomNumber = 10000;
        while (checkExists(bookList, randomNumber)) {
            randomNumber = (int) ((Math.random() * 89999) + 10001);
        }
        return randomNumber;
    }

    private boolean checkExists(List<Book> bookList, int randomNumber) {
        for (Book book : bookList) {
            if (book.getBookCode() == randomNumber) {
                return true;
            }
        }
        return false;
    }


}