package com.library.dao;
import java.util.ArrayList;
import com.library.entity.book;
import com.alibaba.fastjson.JSON;
import java.sql.Date;

public class bookDao extends Dao {
    private ArrayList<book> bookTransfer(ArrayList<Object> result) {
        ArrayList<book> rs = new ArrayList<book>();
        for(Object x : result) {
            book temp = JSON.parseObject(JSON.toJSONString(x), book.class);
            rs.add(temp);
        }
        return rs;
    }

    public ArrayList<book> searchBookByName(String Bname) {
        ArrayList<book> rs;
        String sql = "select * from book where Bname like ?";
        rs = bookTransfer(executeQuery(sql, '%'+Bname+'%'));
        return rs;
    }

    public int searchBookAmount(int BID) {
        ArrayList<book> rs;
        String sql = "select * from book where BID = ?";
        rs = bookTransfer(executeQuery(sql, BID));
        return rs.get(0).getAmount();
    }

    public int addBook(String Bname, String Author, Date Bdate, int Amount) {
        String sql = "insert into book (Bname, Author, Bdate, Amount) values(?,?,?,?)";
        return executeUpdate(sql, Bname, Author, Bdate, Amount);
    }

    public int deleteBook(int BID) {
        String sql = "delete from book where BID = ?";
        return executeUpdate(sql, BID);
    }

    public int updateBook(int BID, String Bname, String Author, Date Bdate, int Amount) {
        String sql = "update book set Bname = ?, Author = ?, Bdate = ?, Amount = ? where BID = ?";
        return executeUpdate(sql, Bname, Author, Bdate, Amount, BID);
    }

    public int changeAmount(int BID, int Change) {
        String sql = "update book set Amount = Amount + ? where BID = ?";
        return executeUpdate(sql, Change, BID);
    }

    public static void main(String[] args){
        bookDao dao = new bookDao();
        String b = "三体";
        ArrayList<book> rs = dao.searchBookByName(b);
        for (book book : rs) {
            System.out.println(book);
        }
    }
}
