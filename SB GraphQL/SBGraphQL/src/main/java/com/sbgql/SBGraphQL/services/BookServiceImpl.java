package com.sbgql.SBGraphQL.services;

import com.sbgql.SBGraphQL.entities.Book;
import com.sbgql.SBGraphQL.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository brep;

    // Create Book
    @Override
    public Book createBook(Book book) {
        return this.brep.save(book);
    }

    // Get all books
    @Override
    public List<Book> getAllBooks() {
        return this.brep.findAll();
    }

    // Get 1 book
    @Override
    public Book getBookById(int id) {
        return this.brep.findById(id).orElseThrow(() -> new RuntimeException("Book unavailable!"));
    }
}
