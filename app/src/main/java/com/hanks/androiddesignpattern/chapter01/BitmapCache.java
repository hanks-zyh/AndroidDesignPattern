package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
/**
 * 图片缓存接口
 * Created by hanks on 15-12-9.
 */
public interface BitmapCache {
    void put(String imageUrl, Bitmap bitmap);
    Bitmap get(String imageUrl);
}
