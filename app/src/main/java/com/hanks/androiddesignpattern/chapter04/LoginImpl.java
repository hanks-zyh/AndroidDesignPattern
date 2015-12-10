package com.hanks.androiddesignpattern.chapter04;
/**
 *
 * Created by hanks on 15-12-10.
 */
public class LoginImpl implements Login {
    @Override public void login() {
        User loginUser = new User();
        loginUser.age = 22;
        loginUser.name = "Hanks";
        loginUser.address = new Address("beijing","ca","22");
        LoginSession.getInstance().setLoginUser(loginUser);
    }
}
