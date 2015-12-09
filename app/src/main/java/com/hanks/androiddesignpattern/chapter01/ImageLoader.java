package com.hanks.androiddesignpattern.chapter01;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 图片加载库
 * Created by hanks on 15-12-9.
 */
public class ImageLoader {

    // 图片缓存
     ImageCache mImageCache = new ImageCache();

    // 线程数,最大数目为cpu的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime()
            .availableProcessors());

    public void displayImage(final ImageView imageView, @NonNull final String url) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (url.equals(imageView.getTag())) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(url, bitmap);
            }
        });
    }

    private  Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
