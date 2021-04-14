package com.library.dao;
import java.util.ArrayList;
import com.library.entity.user;
import com.alibaba.fastjson.JSON;

public class userDao extends Dao {
    private ArrayList<user> userTransfer(ArrayList<Object> result) {
        ArrayList<user> rs = new ArrayList<user>();
        for(Object x : result) {
            user temp = JSON.parseObject(JSON.toJSONString(x), user.class);
            rs.add(temp);
        }
        return rs;
    }

    public ArrayList<user> searchUser(String Uname) {
        ArrayList<user> rs;
        String sql = "select * from user where Uname = ?";
        rs = userTransfer(executeQuery(sql, Uname));
        return rs;
    }

    public int addUser(String Uname, String Pwd) {
        String sql = "insert into user (Uname, Pwd) values(?,?)";
        return executeUpdate(sql, Uname, Pwd);
    }

    public int deleteUser(int UID) {
        String sql = "delete from user where UID = ?";
        return executeUpdate(sql, UID);
    }

    public int updateUser(int UID, String Uname, String Pwd) {
        String sql = "update user set Uname = ?, Pwd = ? where UID = ?";
        return executeUpdate(sql, Uname, Pwd, UID);
    }
}
