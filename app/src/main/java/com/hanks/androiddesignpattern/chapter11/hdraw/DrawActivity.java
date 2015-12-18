package com.hanks.androiddesignpattern.chapter11.hdraw;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.hanks.androiddesignpattern.R;
/**
 * 主Activity
 * Created by hanks on 15-12-18.
 */
public class DrawActivity extends AppCompatActivity {

    private DrawCanvas mCanvas;
    private DrawPath   mPath;
    private Paint      mPaint;
    private IBrush     mBrush;

    private Button btnRedo, btnUndo;

    public void OnClick(View view) {

        switch (view.getId()) {

            case R.id.btn_red:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.RED);
                break;
            case R.id.btn_green:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.GREEN);
                break;
            case R.id.btn_blue:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.BLUE);
                break;
            case R.id.btn_redo:
                mCanvas.redo();
                if (!mCanvas.canRedo()) {
                    btnRedo.setEnabled(false);
                }
                btnUndo.setEnabled(true);
                break;
            case R.id.btn_undo:
                mCanvas.undo();
                if (!mCanvas.canUndo()) {
                    btnUndo.setEnabled(false);
                }
                btnRedo.setEnabled(true);
                break;
            case R.id.btn_circle:
                mBrush = new CircleBrush();
                break;
            case R.id.btn_normal:
                mBrush = new NormalBrush();
                break;

        }
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(0xFFFFFFFF);
        mPaint.setStrokeWidth(3);

        mBrush = new NormalBrush();

        mCanvas = (DrawCanvas) findViewById(R.id.ac_draw_canvas);
        mCanvas.setOnTouchListener(new DrawTouchListener());

        btnRedo = (Button) findViewById(R.id.btn_red);
        btnUndo = (Button) findViewById(R.id.btn_undo);

    }

    private class DrawTouchListener implements View.OnTouchListener {

        @Override public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPath = new DrawPath();
                    mPath.paint = mPaint;
                    mPath.path = new Path();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mBrush.move(mPath.path, event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_UP:
                    mBrush.up(mPath.path, event.getX(), event.getY());
                    mCanvas.add(mPath);
                    mCanvas.isDrawing = true;
                    btnUndo.setEnabled(true);
                    btnRedo.setEnabled(false);
                    break;
            }
            return true;
        }
    }
}
