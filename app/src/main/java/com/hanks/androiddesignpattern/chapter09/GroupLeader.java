package com.hanks.androiddesignpattern.chapter09;
/**
 * Created by hanks on 15-12-12.
 */
public class GroupLeader extends Leader {
    @Override protected void handle(int money) {
        System.out.print("组长允许报销:"+money);
    }

    @Override protected int limit() {
        return 1000;
    }
}
