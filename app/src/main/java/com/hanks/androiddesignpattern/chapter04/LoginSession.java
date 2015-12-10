package com.hanks.androiddesignpattern.chapter04;
/**
 * 用户登录 session
 * Created by hanks on 15-12-10.
 */
public class LoginSession {
    private static LoginSession sInstance;

    private User loginUser;

    private LoginSession() {}

    public static LoginSession getInstance() {
        if (sInstance == null) {
            synchronized (LoginSession.class) {
                if (sInstance == null) {
                    sInstance = new LoginSession();
                }
            }
        }
        return sInstance;
    }

    public User getLoginUser() {
        return loginUser.clone();
    }

    // 设置用户信息,部对外发放
    void setLoginUser(User user) {
        loginUser = user;
    }
}
