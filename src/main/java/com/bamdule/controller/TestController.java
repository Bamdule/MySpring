package com.bamdule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MW
 */
@Controller
public class TestController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String test() {
        return "/WEB-INF/views/hello.jsp";
    }

}
