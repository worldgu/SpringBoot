package com.zero.proficientspringboot;

import com.zero.proficientspringboot.web.WebController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author ：Zero
 * @date ：Created in 2019/5/28 22:05
 * @modified By：
 */
@SpringBootTest
public class WebControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception {
        // andReturn().getResponse().getContentAsString(); ”的意思是获取请求的返回信息，并将返回信息转换为字符串，最后将请求的响应结果打印出来。
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);

        String responseStrings = mockMvc.perform(MockMvcRequestBuilders.get("/getUsers"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseStrings);

        //  如何进行对象查询   测试失败
        // TODO  测试失败
//        String responseStringnew = mockMvc.perform(MockMvcRequestBuilders.post("/getUsernew").param("name","77").param("age","77"))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println("result : "+responseStringnew);

    }
}
