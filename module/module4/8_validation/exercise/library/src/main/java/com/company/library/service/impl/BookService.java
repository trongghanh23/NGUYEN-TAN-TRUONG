package com.company.library.service.impl;



import com.company.library.model.Book;
import com.company.library.repository.IBookRepository;
import com.company.library.repository.ILibraryRepository;
import com.company.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Autowired
    private ILibraryRepository iLibraryRepository;

    @Override
    public List<Book> findAll() {
        return this.iBookRepository.findAll();
    }

    @Override
    public void setStatus(Integer id) {
        this.iBookRepository.setStatus(id);
    }

    @Override
    public void returnBook(Integer bookCode) throws Exception {
        List<Book> bookList = this.iBookRepository.findAll();
        Book book = this.iBookRepository.getByBookCode(bookCode);
        if (checkBookCodeExists(bookCode, bookList)) {
            this.iBookRepository.updateStatus(book.getId());
            this.iLibraryRepository.updateQuantity(book.getLibrary().getId());
        } else {
            throw new Exception();
        }
    }

    private boolean checkBookCodeExists(Integer bookCode, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getBookCode().equals(bookCode) && book.getStatus()) {
                return true;
            }
        }
        return false;
    }
}