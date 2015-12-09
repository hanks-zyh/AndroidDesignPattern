package com.hanks.androiddesignpattern.chapter01;
import java.io.Closeable;
import java.io.IOException;
/**
 * 负责处理 closeable 接口的 close
 * Created by hanks on 15-12-9.
 */
public class CloseUtils {
    private  CloseUtils(){}

    public static void closeQuietly(Closeable closeable){
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
