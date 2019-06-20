package com.zero.proficientspringboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.jsp.JspApplicationContext;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/20 21:42
 * @modified By：
 */
public class ServletInitializer extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JspApplicationContext.class);
    }

}
