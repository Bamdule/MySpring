package com.bamdule.controller;

import com.bamdule.model.vo.UserVO;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MW
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("#{config['jdbc.driver']}")
    String data;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("[MYTEST] data : {}",data);
        return "home";
    }

//    @ResponseBody
    @RequestMapping(value = "/validTest", method = RequestMethod.GET)
    public void validTest(
            @Valid UserVO userVO,
            BindingResult result
    ) {
        logger.info("[MYTEST] {}", userVO);
        logger.info("[MYTEST] error : {}", result.hasErrors());

        // 에러가 있는지 검사
        if (result.hasErrors()) {
            logger.info("[has ERROR]");
            result.getAllErrors().forEach(error -> logger.info("[MYTEST] {}", error));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() {
        double a = 1 / 0;
        return "home";
    }

}
