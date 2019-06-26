package com.zero.proficientspringboot;

import com.zero.proficientspringboot.comm.NeoProperties;
import com.zero.proficientspringboot.comm.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/19 21:13
 * @modified By：
 * 读取配置文件yml的配置信息
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Value("${neo.title}")
    private String title;

    @Resource
    private NeoProperties properties;

    @Test
    public void testSingle() {
        Assert.assertEquals(title, "Zero");
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:" + properties.getTitle());
        System.out.println("description:" + properties.getDescription());
    }

    @Resource
    private OtherProperties otherproperties;

    @Test
    public void testOther() throws Exception {
        System.out.println("title:" + otherproperties.getTitle());
        System.out.println("blog:" + otherproperties.getBlog());
    }
}
