package com.library.service;
import com.library.dao.bookDao;
import com.library.entity.book;
import java.util.ArrayList;

public class bookService {
    private bookDao db;

    public RetResult searchBook(String Bname) {
        ArrayList<book> books = db.searchBookByName(Bname);
        return new RetResult(200, books);
    }

    public RetResult addBook(book Book) {
        int code = db.addBook(Book.getBname(), Book.getAuthor(), Book.getBdate(), Book.getAmount());
        if(code == -1) {
            return new RetResult(400,"添加失败");
        }
        else { return new RetResult(200,"添加成功"); }
    }

    public RetResult deleteBook(book Book) {
        int code = db.deleteBook(Book.getBID());
        if(code == -1) {
            return new RetResult(400,"删除失败");
        }
        else { return new RetResult(200,"删除成功"); }
    }

    public RetResult updateBook(book Book) {
        int code = db.updateBook(Book.getBID(), Book.getBname(), Book.getAuthor(), Book.getBdate(), Book.getAmount());
        if(code == -1) {
            return new RetResult(400,"修改失败");
        }
        else { return new RetResult(200,"修改成功"); }
    }
}
