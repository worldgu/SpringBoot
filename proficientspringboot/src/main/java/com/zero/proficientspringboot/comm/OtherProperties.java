package com.zero.proficientspringboot.comm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/19 21:30
 * @modified By：
 */
@Component
@ConfigurationProperties(prefix = "other")
@PropertySource("classpath:other.properties")
public class OtherProperties {

    private String title;
    private String blog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
