package com.racofix.basic4.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.racofix.anmvp.BaseActivity;
import com.racofix.logic.annotation.Implement;


@Implement(LoginLogicImpl.class)
public class LoginAct extends BaseActivity<LoginLogicImpl> implements LoginLogic.LoginVo {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.req).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogicImpl.login("zhangsan", "123456");
            }
        });
    }

    @Override
    public void successful(String msg) {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
