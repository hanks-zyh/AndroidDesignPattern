package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 管理图片在sd的缓存
 * Created by hanks on 15-12-9.
 */
public class DiskCache {
    static String cacheDir = "sdcard/cache";

    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+ url);
    }

    public void put(String imageUrl, Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + imageUrl);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
