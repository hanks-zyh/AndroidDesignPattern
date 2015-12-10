package com.hanks.androiddesignpattern.chapter05;
/**
 * Created by hanks on 15-12-10.
 */
public class IOFactory {

    public static <T extends IOHandler> T getIOHandler(Class<T> clz) {

        IOHandler ioHandler = null;
        try {
            ioHandler = (IOHandler) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) ioHandler;
    }
}
