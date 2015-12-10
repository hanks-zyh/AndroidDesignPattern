package com.hanks.androiddesignpattern.chapter06;
/**
 * Created by hanks on 15-12-10.
 */
public class Q7Factory extends CarFactory {

    @Override public ITire createTire() {
        return new SUVTire();
    }

    @Override public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override public IBrake createBrake() {
        return new SeniroBrake();
    }
}
