package com.hanks.androiddesignpattern.chapter01;
/**
 * 顺序加载
 * Created by hanks on 15-12-11.
 */
public class SerialPolicy implements LoadPolicy {
    @Override public int compare(BitmapRequest request1, BitmapRequest request2) {
        return request1.serialNum - request2.serialNum ;
    }
}
