package com.library.entity;
import java.sql.Date;

public class book {
    private int BID;
    private String Bname;
    private String Author;
    private int Amount;
    private Date Bdate;

    public void setBID(int BID) {
        this.BID = BID;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public void setBdate(Date Bdate) {
        this.Bdate = Bdate;
    }

    public int getBID() {
        return BID;
    }

    public int getAmount() {
        return Amount;
    }

    public String getBname() {
        return Bname;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getBdate() {
        return Bdate;
    }
}
