package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 存储画笔动作
 * Created by hanks on 15-12-18.
 */
public class DrawInvoker {

    private List<DrawPath> drawList = Collections.synchronizedList(new ArrayList<DrawPath>());
    private List<DrawPath> redoList = Collections.synchronizedList(new ArrayList<DrawPath>());

    public void add(DrawPath path) {
        redoList.clear();
        drawList.add(path);
    }

    public void undo() {
        if (drawList.size() > 0) {
            DrawPath undo = drawList.get(drawList.size() - 1);
            drawList.remove(undo);
            undo.undo();
            redoList.add(undo);
        }
    }

    public void redo() {
        if (redoList.size() > 0) {
            DrawPath redo = redoList.get(redoList.size() - 1);
            redoList.remove(redo);
            drawList.add(redo);
        }
    }

    public void execute(Canvas canvas) {
        if (drawList != null) {
            for (DrawPath tmp : drawList) {
                tmp.draw(canvas);
            }
        }
    }

    public boolean canRedo() {
        return redoList.size() > 0;
    }

    public boolean canUndo() {
        return drawList.size() > 0;
    }
}
