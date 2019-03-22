package com.bamdule.controller;

import com.bamdule.model.vo.UserVO;
import java.security.Principal;
import java.util.Objects;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MW
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("#{config['jdbc.driver']}")
    String data;

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model
    ) {
        if (error != null) {
            model.addAttribute("msg", "Invalid username and password");
        }
        if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully");
        }
        
        return "login"; // login.jsp(Custom Login Page)
    }

    @PreAuthorize("hasAuthority('NORMAL')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("[MYTEST] data : {}", data);
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

}
