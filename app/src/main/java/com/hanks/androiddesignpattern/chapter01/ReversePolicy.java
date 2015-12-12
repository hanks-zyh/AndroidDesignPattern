package com.hanks.androiddesignpattern.chapter01;
/**
 * 逆序加载, 从最后的请求进行加载
 * Created by hanks on 15-12-11.
 */
public class ReversePolicy implements LoadPolicy {
    @Override public int compare(BitmapRequest request1, BitmapRequest request2) {

        return request2.serialNum - request1.serialNum;
    }
}
