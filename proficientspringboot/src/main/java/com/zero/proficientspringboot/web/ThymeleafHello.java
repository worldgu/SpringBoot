package com.zero.proficientspringboot.web;

import com.zero.proficientspringboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * =======  基本对象
 * #ctx：上下文对象
 * #vars：上下文变量
 * #locale：区域对象
 * #request：（仅 Web 环境可用）HttpServletRequest 对象
 * #response：（仅 Web 环境可用）HttpServletResponse 对象
 * #session：（仅 Web 环境可用）HttpSession 对象
 * #servletContext：（仅 Web 环境可用）ServletContext 对象
 * <p>
 * ======   内嵌变量  Thymeleaf 还提供了一系列Utility 对象(内置于Context中)通过 # 直接访问
 * dates：java.util.Date 的功能方法类
 * calendars：类似 #dates，面向 java.util.Calendar
 * numbers：格式化数字的功能方法类
 * strings：字符串对象的功能类，contains、startWiths、prepending/appending 等
 * objects：对 objects 的功能类操作
 * bools：对布尔值求值的功能方法
 * arrays：对数组的功能类方法
 * lists：对 lists 的功能类方法
 * sets：set 的实用方法
 * maps：map 的实用方法
 */

/**
 * @author ：Zero
 * @date ：Created in 2019/6/20 22:03
 * @modified By：
 */
@Controller
public class ThymeleafHello {

    @RequestMapping("/thymaleay")
    public String index(ModelMap map) {
        map.addAttribute("message", "http://www.ityouknow.com");
        return "thymeleafHello";
    }

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "ityouknow");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "neo");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("userName", "neo");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request) {
        request.setAttribute("request", "i am request");
        request.getSession().setAttribute("session", "i am session");
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute("userName", "Zero");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "utility";
    }


    private List<User> getUserList() {
        List<User> list = new ArrayList<User>();
        User user1 = new User("大牛", 12, "123456");
        User user2 = new User("小牛", 6, "123563");
        User user3 = new User("纯洁的微笑", 66, "666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
