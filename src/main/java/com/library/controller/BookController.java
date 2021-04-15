package com.library.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.library.entity.book;
import com.library.dao.bookDao;

@RestController
public class BookController {
    // 使用@RequstMapping指定可以访问的URL路径
    @RequestMapping(value ="/books/{name}")
    public List<book> getAllTodos(@PathVariable String name) {
        bookDao dao = new bookDao();
        List<book> books = dao.searchBookByName(name);
        return books;
    }
}