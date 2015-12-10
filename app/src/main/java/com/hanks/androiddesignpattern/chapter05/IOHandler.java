package com.hanks.androiddesignpattern.chapter05;
/**
 * 工厂方法
 * Created by hanks on 15-12-10.
 */
public abstract  class IOHandler {

    public abstract void add(String id,String name);
    public abstract void remove(String id);
    public abstract void update(String id,String name);
    public abstract void query(String id);
}
