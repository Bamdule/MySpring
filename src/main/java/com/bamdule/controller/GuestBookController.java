package com.bamdule.controller;

import com.bamdule.dao.GuestBookDao;
import com.bamdule.exception.GuestBookException;
import com.bamdule.model.vo.GuestBookVO;
import com.bamdule.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/guestBook")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String guestBookListView() {
//        guestBookService.insert(new GuestBookVO("hark", "12345", "안녕!", "2019-01-01 23:55:01"));
        System.out.println(guestBookService.list());
        return "hello";
    }

}
