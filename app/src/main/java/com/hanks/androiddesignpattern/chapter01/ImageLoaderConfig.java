package com.hanks.androiddesignpattern.chapter01;
import android.support.annotation.DrawableRes;
/**
 * 配置 ImageLoader
 * Created by hanks on 15-12-9.
 */
public class ImageLoaderConfig {

    BitmapCache bitmapCache = new MemoryCache();

    DisplayConfig displayConfig = new DisplayConfig();

    LoadPolicy loadPolicy = new SerialPolicy();

    // cpu 数量加一个分发线程
    int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    private ImageLoaderConfig() {}

    /**
     * 使用builder模式
     */
    public static class Builder {

        // 图片缓存配置
        BitmapCache bitmapCache = new MemoryCache();

        // 加载图片时的loading和加载失败配置
        DisplayConfig displayConfig = new DisplayConfig();

        // 加载策略
        LoadPolicy loadPolicy = new SerialPolicy();

        //线程数量
        int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        public Builder setLoadingResId(@DrawableRes int id){
            displayConfig.loadingResId = id;
            return this;
        }
        public Builder setLoadFailResId(@DrawableRes int id){
            displayConfig.loadFailId = id;
            return this;
        }
        public Builder setThreadCount(int threadCount) {
            this.threadCount = Math.max(1, threadCount);
            return this;
        }

        public Builder setBitmapCache(BitmapCache bitmapCache) {
            this.bitmapCache = bitmapCache;
            return this;
        }

        public Builder setDisplayConfig(DisplayConfig displayConfig) {
            this.displayConfig = displayConfig;
            return this;
        }

        public Builder setLoadPolicy(LoadPolicy loadPolicy) {
            if (loadPolicy != null) {
                this.loadPolicy = loadPolicy;
            }
            return this;
        }

        void applyConfig(ImageLoaderConfig config) {
            config.bitmapCache = this.bitmapCache;
            config.threadCount = this.threadCount;
            config.displayConfig = this.displayConfig;
            config.threadCount = this.threadCount;
        }

        public ImageLoaderConfig create() {
            ImageLoaderConfig config = new ImageLoaderConfig();
            applyConfig(config);
            return config;
        }
    }

}
