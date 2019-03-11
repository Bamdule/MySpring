package com.bamdule.controller;

import com.bamdule.service.GuestBookService;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/guestBook")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String guestBookListView() {
        List<Map<String, Object>> list = guestBookService.list();

        for (int i = 0; i < 100; i++) {
            logger.info("[MYTEST] -> {}", list);
        }
        System.out.println(guestBookService.list());
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "data", method = RequestMethod.GET)
    public List<Map<String, Object>> test() {
        guestBookService.list().forEach(data -> System.out.println(data));
        return guestBookService.list();
    }

}
