package com.hanks.androiddesignpattern.chapter06;
/**
 * 抽象工厂方法
 * Created by hanks on 15-12-10.
 */
public abstract class CarFactory {
    public abstract ITire createTire();
    public abstract IEngine createEngine();
    public abstract IBrake createBrake();
}
