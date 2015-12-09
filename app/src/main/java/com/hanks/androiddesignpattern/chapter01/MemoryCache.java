package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
import android.util.LruCache;
/**
 * 负责管理图片缓存
 * Created by hanks on 15-12-9.
 */
public class MemoryCache implements BitmapCache {
    LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override public Bitmap get(String url) {
        return mImageCache.get(url);
    }

    @Override public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }
}
