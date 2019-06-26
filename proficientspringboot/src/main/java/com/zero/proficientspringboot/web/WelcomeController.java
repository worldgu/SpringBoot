package com.zero.proficientspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/20 14:55
 * @modified By：
 */
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Hello World");
        return "welcome";

    }

    @GetMapping("/user")
    public String user(Map<String, Object> model, HttpServletRequest request) {
        model.put("username", "neo");
        model.put("salary", 666);
        request.getSession().setAttribute("count", 6);
        return "user";
    }
}
