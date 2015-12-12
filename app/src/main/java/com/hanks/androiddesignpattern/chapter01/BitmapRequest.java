package com.hanks.androiddesignpattern.chapter01;
import android.support.annotation.NonNull;
import android.widget.ImageView;
/**
 * 加载请求
 * Created by hanks on 15-12-11.
 */
public class BitmapRequest implements Comparable<BitmapRequest> {
    public int serialNum;

    LoadPolicy loadPolicy = new SerialPolicy();
    public DisplayConfig displayConfig;

    public BitmapRequest(ImageView imageView, String url, ImageLoaderConfig config, ImageLoaderListener listener) {

    }

    @Override public int compareTo(@NonNull BitmapRequest another) {
        return loadPolicy.compare(this, another);
    }

    public void setLoadPolicy(LoadPolicy loadPolicy) {
        this.loadPolicy = loadPolicy;
    }
}
