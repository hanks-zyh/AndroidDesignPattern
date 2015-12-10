package com.hanks.androiddesignpattern.chapter06;
/**
 *
 * Created by hanks on 15-12-10.
 */
public class NormalTire implements ITire {
    @Override public void makeTire() {
        System.out.print("普通轮胎");
    }
}
