package com.hanks.androiddesignpattern.chapter06;
/**
 * Created by hanks on 15-12-10.
 */
public class NormalBrake implements IBrake {
    @Override public void makeBrake() {
        System.out.print("普通制动");
    }
}
