package com.zero.proficientspringboot.web;

import com.zero.proficientspringboot.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Zero
 * @date ：Created in 2019/5/28 22:02
 * @modified By：
 */
@RestController
public class WebController {

    @RequestMapping(name="/getUser",method = RequestMethod.POST)
    public User getUser(){
        User user=new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=new ArrayList<User>();
        User user1=new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        users.add(user1);
        User user2=new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPass("123456");
        users.add(user2);
        return users;
    }

    // 注释打开启动报错
    // Invocation of init method failed; nested exception is java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'webController' method
//    @RequestMapping(name="/getnew",method = RequestMethod.POST)
//    public User getnew(User newuser){
//        User user=new User();
//        user.setName("小明");
//        user.setAge(newuser.getAge());
//        user.setPass("123456");
//        return user;
//    }

    @RequestMapping(value="get/{name}", method=RequestMethod.GET)
    public String get(@PathVariable String name) {
        return name;
    }

    @RequestMapping("saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        System.out.println("User :" + user);
        if ( result.hasErrors() ) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
