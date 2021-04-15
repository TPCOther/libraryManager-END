package com.library.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("api")
public class userController {

    @RequestMapping(value ="/user/login", method = RequestMethod.POST)
    public RetResult login(@RequestBody String User) {
        JSONObject json = (JSONObject)JSON.parse(User);
        return userService.userLogin(json.getString("Uname"), json.getString("Pwd"));
    }

    @RequestMapping(value ="/user/register", method = RequestMethod.POST)
    public RetResult register(@RequestBody String User) {
        JSONObject json = (JSONObject)JSON.parse(User);
        return userService.userRegister(json.getString("Uname"), json.getString("Pwd"));
    }
    
}
