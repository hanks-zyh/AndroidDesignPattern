package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Path;
/**
 * 普通笔刷
 * Created by hanks on 15-12-18.
 */
public class NormalBrush implements IBrush {
    @Override public void down(Path path, float x, float y) {
        path.moveTo(x, y);
    }

    @Override public void move(Path path, float x, float y) {
        path.lineTo(x, y);
    }

    @Override public void up(Path path, float x, float y) {

    }
}
