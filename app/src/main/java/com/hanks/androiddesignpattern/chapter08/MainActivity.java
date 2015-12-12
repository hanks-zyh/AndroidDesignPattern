package com.hanks.androiddesignpattern.chapter08;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hanks.androiddesignpattern.R;
/**
 * Created by hanks on 15-12-12.
 */
public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.forward).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LoginContext.getInstance().forward(MainActivity.this);
            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LoginContext.getInstance().setState(new LogoutState());
            }
        });
    }
}
