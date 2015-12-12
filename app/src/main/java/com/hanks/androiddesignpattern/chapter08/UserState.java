package com.hanks.androiddesignpattern.chapter08;
import android.content.Context;
/**
 * 状态模式
 * Created by hanks on 15-12-12.
 */
public interface UserState {

    void forward(Context context);
    void comment(Context context);
}
