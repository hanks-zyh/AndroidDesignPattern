package com.hanks.androiddesignpattern.chapter08;
import android.content.Context;
/**
 * 管理用户状态
 * Created by hanks on 15-12-12.
 */
public class LoginContext {
    private static LoginContext sInstance = new LoginContext();
    private UserState mState = new LogoutState();

    private LoginContext() {}


    public static LoginContext getInstance() {
        return sInstance;
    }

    public void setState(UserState mState) {
        this.mState = mState;
    }

    public void forward(Context context) {
        mState.forward(context);
    }

    public void comment(Context context) {
        mState.comment(context);
    }
}
