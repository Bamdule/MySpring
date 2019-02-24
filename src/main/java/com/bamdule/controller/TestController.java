package com.bamdule.controller;

import com.bamdule.dao.GuestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MW
 */
@Controller
public class TestController {

    @Autowired
    private GuestBookDao guestBookDao;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String test() {

        System.out.println(guestBookDao);
        return "hello";
    }

}
