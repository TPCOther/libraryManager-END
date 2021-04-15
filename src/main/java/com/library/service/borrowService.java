package com.library.service;

import java.util.ArrayList;

import com.library.dao.borrowDao;
import com.library.dao.bookDao;
import com.library.entity.borrow;

public class borrowService {
    private borrowDao borrowdao;
    private bookDao bookdao;

    public RetResult queryBorrowByUser(int UID) {
        ArrayList<borrow> data = borrowdao.searchBorrowByUser(UID);
        return new RetResult(200,data);
    }

    public RetResult borrowBook(int BID, int UID) {
        int amout = bookdao.searchBookAmount(BID);
        if(amout<=0) { return new RetResult(200,"已无存书"); }
        int code = borrowdao.addBorrow(UID, BID);
        if(code == -1){ return new RetResult(400,"借出失败"); }
        else { 
            bookdao.changeAmount(BID, -1);
            return new RetResult(200,"借出成功"); 
        }
    }

    public RetResult returnBook(int RID, int BID) {
        int code = bookdao.changeAmount(BID, 1);
        if(code == -1) {
            return new RetResult(400,"还书失败");
        }
        else {
            borrowdao.updateBorrow(RID);
            return new RetResult(200, "还书成功");
        }
    }
}
