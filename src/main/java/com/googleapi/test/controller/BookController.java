package com.googleapi.test.controller;


import com.googleapi.test.model.Book;
import com.googleapi.test.service.GoogleBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final GoogleBookService googleBookService;

    public BookController(GoogleBookService googleBookService) {
        this.googleBookService = googleBookService;
    }

    @GetMapping("/search-books/{query}")
    public List<Book> searchBooks(@PathVariable(name = "query") String query,
                                  @RequestParam(name = "page") Long page,
                                  @RequestParam(name = "size") Long size){
        return googleBookService.getBooks(query,page,size);
    }
    @GetMapping("/{id}")
    public Book searchBook(@PathVariable(name = "id") String id){
        return googleBookService.getBook(id);
    }
}
