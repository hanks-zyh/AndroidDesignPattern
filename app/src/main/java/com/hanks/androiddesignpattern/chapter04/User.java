package com.hanks.androiddesignpattern.chapter04;
/**
 * 用户信息
 * Created by hanks on 15-12-10.
 */
public class User implements Cloneable {

    public int     age;
    public String  name;
    public String  phone;
    public Address address;

    @Override public User clone() {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}


