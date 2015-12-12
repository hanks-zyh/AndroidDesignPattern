package com.hanks.androiddesignpattern.chapter08;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Created by hanks on 15-12-12.
 */
public class LoginActivity extends AppCompatActivity{
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button textView = new Button(this);
        textView.setText("登录界面");
        setContentView(textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LoginContext.getInstance().setState(new LoginedState());
            }
        });
    }
}
