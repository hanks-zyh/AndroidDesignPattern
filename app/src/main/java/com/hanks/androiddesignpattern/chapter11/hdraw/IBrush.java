package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Path;
/**
 *
 * Created by hanks on 15-12-18.
 */
public interface IBrush {

    void down(Path path, float x , float y);
    void move(Path path, float x , float y);
    void up(Path path, float x , float y);
}
