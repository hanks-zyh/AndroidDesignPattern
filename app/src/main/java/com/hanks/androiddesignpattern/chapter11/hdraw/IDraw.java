package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Canvas;
/**
 * 画图动作: 撤销,重做
 * Created by hanks on 15-12-18.
 */
public interface IDraw {

    void draw(Canvas canvas);
    void undo();
}

