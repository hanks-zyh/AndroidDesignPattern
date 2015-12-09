package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
/**
 * 获取图片先从内存获取,内存没有从sd卡获取
 * 缓存图片在内存和sd卡都缓存一份
 * Created by hanks on 15-12-9.
 */
public class DoubleCache implements BitmapCache {
    MemoryCache mImageCache = new MemoryCache();
    DiskCache   mDiskCache  = new DiskCache();

    // 先从内存获取,内存没有从sd卡获取
    @Override public Bitmap get(String imageUrl) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap == null) {
            bitmap = mDiskCache.get(imageUrl);
        }
        return bitmap;
    }

    @Override public void put(String imageUrl, Bitmap bitmap) {
        mImageCache.put(imageUrl, bitmap);
        mDiskCache.put(imageUrl, bitmap);
    }

}
