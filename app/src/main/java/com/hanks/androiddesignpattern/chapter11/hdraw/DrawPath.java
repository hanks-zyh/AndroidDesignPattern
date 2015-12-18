package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
/**
 * 绘制路径
 * Created by hanks on 15-12-18.
 */
public class DrawPath implements IDraw {

    public Paint paint;
    public Path  path;

    @Override public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override public void undo() {

    }
}
