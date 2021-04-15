package com.library.service;

import java.util.ArrayList;
import com.library.dao.userDao;
import com.library.entity.user;

public class userService {
    private userDao db;

    public RetResult userRegister(String Uname, String Pwd) {
        int code = db.addUser(Uname, Pwd);
        if(code == -1) { return new RetResult(400,"注册失败"); }
        else { return new RetResult(200, "注册成功"); }
    }

    public RetResult userLogin(String Uname, String Pwd) {
         ArrayList<user> users = db.searchUser(Uname);
         if(users.isEmpty()) { return new RetResult(200, "用户不存在"); }
         user login = users.get(0);
         if(login.login(Pwd)) {
             return new RetResult(200, "登录成功", login.getUID());
         }
         else { return new RetResult(200, "密码错误"); }
    }
}
