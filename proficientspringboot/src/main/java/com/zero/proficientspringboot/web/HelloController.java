package com.zero.proficientspringboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Zero
 * @date ：Created in 2019/5/27 23:23
 * @modified By：
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name ) {
        return "Hello World" + name;
    }
}
