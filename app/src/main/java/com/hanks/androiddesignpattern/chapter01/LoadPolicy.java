package com.hanks.androiddesignpattern.chapter01;
/**
 * 加载策略,使用策略模式
 * Created by hanks on 15-12-9.
 */
public interface LoadPolicy {
    int compare(BitmapRequest request1,BitmapRequest request2);
}
