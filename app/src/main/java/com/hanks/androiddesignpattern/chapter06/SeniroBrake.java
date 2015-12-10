package com.hanks.androiddesignpattern.chapter06;
/**
 * Created by hanks on 15-12-10.
 */
public class SeniroBrake  implements  IBrake{
    @Override public void makeBrake() {
        System.out.print("高级制动");
    }
}
