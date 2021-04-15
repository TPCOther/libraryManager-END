package com.library.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("api")
public class borrowController {
    @RequestMapping(value ="/borrow/{uid}", method = RequestMethod.GET)
    public RetResult queryBorrow(@PathVariable int uid) {
        return borrowService.queryBorrowByUser(uid);
    }

    @RequestMapping(value ="/borrow", method = RequestMethod.POST, produces = "application/json")
    public RetResult addBorrow(@RequestBody String info) {
        JSONObject json = (JSONObject)JSON.parse(info);
        return borrowService.borrowBook(json.getIntValue("bid"), json.getIntValue("uid"));
    }

    @RequestMapping(value ="/borrow", method = RequestMethod.PUT)
    public RetResult updateBook(@RequestBody String info) {
        JSONObject json = (JSONObject)JSON.parse(info);
        return borrowService.returnBook(json.getIntValue("rid"), json.getIntValue("bid"));
    }
}
