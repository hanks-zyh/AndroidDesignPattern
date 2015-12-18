package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * 画图板
 * Created by hanks on 15-12-18.
 */
public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback {

    public  boolean     isDrawing;
    Bitmap mBitmap;
    private DrawInvoker mInvoker;
    private boolean     isRunning;
    private DrawThread  mThread;

    public DrawCanvas(Context context) {
        super(context);
        init(null, 0);
    }

    public DrawCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DrawCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) public DrawCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);

    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        mInvoker = new DrawInvoker();
        mThread = new DrawThread();
        getHolder().addCallback(this);
    }

    public void add(DrawPath path) {
        mInvoker.add(path);
    }

    public void redo() {
        isDrawing = true;
        mInvoker.redo();
    }

    public void undo() {
        isDrawing = true;
        mInvoker.undo();
    }

    public boolean canUndo() {
        return mInvoker.canUndo();
    }

    public boolean canRedo() {
        return mInvoker.canRedo();
    }

    @Override public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        mThread.start();
    }

    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    }

    @Override public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        isRunning = false;
        while (retry) {
            try {
                mThread.join();
                retry = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class DrawThread extends Thread {

        @Override public void run() {
            Canvas canvas = null;
            while (isRunning) {
                if (isDrawing) {
                    try {
                        canvas = getHolder().lockCanvas(null);
                        if (mBitmap != null) {
                            mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR); //清楚画布

                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        mInvoker.execute(c);
                        canvas.drawBitmap(mBitmap, 0, 0, null);
                    } catch (Exception e) {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                    isDrawing = false;
                }
            }
        }
    }
}
