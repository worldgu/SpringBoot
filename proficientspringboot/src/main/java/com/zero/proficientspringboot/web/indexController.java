package com.zero.proficientspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/25 20:59
 * @modified By：
 */
@Controller
public class indexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/fragment")
    public String fragment() {
        return "fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
