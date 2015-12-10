package com.hanks.androiddesignpattern.chapter06;
/**
 * Created by hanks on 15-12-10.
 */
public class Q3Factory extends CarFactory {
    @Override public ITire createTire() {
        return new NormalTire();
    }

    @Override public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override public IBrake createBrake() {
        return new NormalBrake();
    }
}
