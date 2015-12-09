package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
import android.util.LruCache;
/**
 * 负责管理图片缓存
 * Created by hanks on 15-12-9.
 */
public class ImageCache {
    LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
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

    public Bitmap get(String url) {
        return mImageCache.get(url);
    }

    public Bitmap put(String url, Bitmap bitmap) {
        return mImageCache.put(url, bitmap);
    }
}
