package com.zero.proficientspringboot;

import com.zero.proficientspringboot.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author ：Zero
 * @date ：Created in 2019/5/28 21:39
 * @modified By：
 */
@SpringBootTest
public class HelloTest {

//    @Test
//    public void hello(){
//        System.out.println("Hello World");
//    }

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        // 请求接口  设置JSON的返回编码格式   打印请求过程  andDo(print())
//        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
//                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andDo(print());

        //  MockMvcResultMatchers.content()，这段代码的意思是获取到 Web 请求执行后的结果；
        //  Matchers.containsString("小明")，判断返回的结果集中是否包含“小明”这个字符串。
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().
                        string(Matchers.containsString("111")));

    }
}
