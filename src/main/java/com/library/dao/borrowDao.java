package com.library.dao;
import java.util.ArrayList;
import com.library.entity.borrow;
import com.alibaba.fastjson.JSON;

public class borrowDao extends Dao {
    private ArrayList<borrow> borrowTransfer(ArrayList<Object> result) {
        ArrayList<borrow> rs = new ArrayList<borrow>();
        for(Object x : result) {
            borrow temp = JSON.parseObject(JSON.toJSONString(x), borrow.class);
            rs.add(temp);
        }
        return rs;
    }

    public ArrayList<borrow> searchBorrowByUser(int UID) {
        ArrayList<borrow> rs;
        String sql = "select * from borrow where UID = ?";
        rs = borrowTransfer(executeQuery(sql, UID));
        return rs;
    }

    public ArrayList<borrow> searchBorrowByBook(int BID) {
        ArrayList<borrow> rs;
        String sql = "select * from borrow where BID = ?";
        rs = borrowTransfer(executeQuery(sql, BID));
        return rs;
    }

    public int addBorrow(int UID, int BID) {
        String sql = "insert into borrow (UID, BID, borrowDate) values(?, ?, now())";
        return executeUpdate(sql, UID, BID);
    }

    public int deleteBorrow(int RID) {
        String sql = "delete from borrow where RID = ?";
        return executeUpdate(sql, RID);
    }

    public int updateBorrow(int RID) {
        String sql = "update borrow set returnDate = now() where RID = ?";
        return executeUpdate(sql, RID);
    }
}
