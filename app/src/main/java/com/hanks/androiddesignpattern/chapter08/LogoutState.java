package com.hanks.androiddesignpattern.chapter08;
import android.content.Context;
import android.content.Intent;
/**
 * Created by hanks on 15-12-12.
 */
public class LogoutState implements UserState {
    @Override public void forward(Context context) {
        goLoginActivity(context);
    }

    @Override public void comment(Context context) {
        goLoginActivity(context);
    }

    private void goLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }
}
