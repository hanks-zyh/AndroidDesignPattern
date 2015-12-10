package com.hanks.androiddesignpattern.chapter06;
/**
 * Created by hanks on 15-12-10.
 */
public class Client {

    public static void main(){
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.createTire().makeTire();
        factoryQ3.createBrake().makeBrake();
        factoryQ3.createEngine().makeEngine();

        CarFactory factoryQ7 = new Q7Factory();
        factoryQ7.createTire().makeTire();
        factoryQ7.createBrake().makeBrake();
        factoryQ7.createEngine().makeEngine();
    }
}
