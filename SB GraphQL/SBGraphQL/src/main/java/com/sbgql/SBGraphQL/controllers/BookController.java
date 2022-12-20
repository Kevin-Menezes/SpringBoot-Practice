package com.sbgql.SBGraphQL.controllers;

import com.sbgql.SBGraphQL.entities.Book;
import com.sbgql.SBGraphQL.entities.BookInput;
import com.sbgql.SBGraphQL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bs;

    // Create Book
    @MutationMapping("CreateBook")
    public Book createBook(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return this.bs.createBook(b);
    }

    // Get all books
    @QueryMapping("GetAllBooks")
    public List<Book> getAllBooks(){
        return this.bs.getAllBooks();
    }

    // Get 1 book by id
    @QueryMapping("GetBook")
    public Book getBookById(@Argument int bookId){
        return this.bs.getBookById(bookId);
    }
}
