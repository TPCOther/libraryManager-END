package com.library.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.*;

import com.library.entity.book;

@RestController
@RequestMapping("api")
public class BookController {
    
    // 使用@RequstMapping指定可以访问的URL路径
    @RequestMapping(value ="/books/{name}", method = RequestMethod.GET)
    public RetResult searchBook(@PathVariable String name) {
        return bookService.searchBook(name);
    }

    @RequestMapping(value ="/books", method = RequestMethod.POST, produces = "application/json")
    public RetResult addBook(@RequestBody book newbook) {
        return bookService.addBook(newbook);
    }

    @RequestMapping(value = "/books", method = RequestMethod.DELETE)
    public RetResult deleteBook(@RequestBody book dbook) {
        return bookService.deleteBook(dbook);
    }

    @RequestMapping(value ="/books", method = RequestMethod.PUT)
    public RetResult updateBook(@RequestBody book newBook) {
        return bookService.updateBook(newBook);
    }
}