package com.zero.proficientspringboot.model;

/**
 * @author ：Zero
 * @date ：Created in 2019/5/28 21:58
 * @modified By：
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;
}
