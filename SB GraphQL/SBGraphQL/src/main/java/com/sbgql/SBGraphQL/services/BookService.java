package com.sbgql.SBGraphQL.services;

import com.sbgql.SBGraphQL.entities.Book;
import com.sbgql.SBGraphQL.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BookService {

    // Create Book
    public Book createBook(Book book);

    // Get all books
    public List<Book> getAllBooks();

    // Get 1 book
    public Book getBookById(int id);


}
