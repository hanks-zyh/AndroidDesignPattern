package com.hanks.androiddesignpattern.chapter08;
import android.content.Context;
import android.widget.Toast;
/**
 * Created by hanks on 15-12-12.
 */
public class LoginedState implements UserState {

    @Override public void forward(Context context) {
        Toast.makeText(context, "转发微博", Toast.LENGTH_SHORT).show();
    }

    @Override public void comment(Context context) {
        Toast.makeText(context, "评论微博", Toast.LENGTH_SHORT).show();

    }
}
