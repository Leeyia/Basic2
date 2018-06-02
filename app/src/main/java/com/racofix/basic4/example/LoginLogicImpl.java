package com.racofix.basic4.example;

import android.os.Handler;

import com.racofix.persistence.LogicImpl;

public class LoginLogicImpl extends LogicImpl<LoginLogic.LoginVo> implements LoginLogic {

    @Override
    public void login(final String username, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equals("zhangsan") && password.equals("12345"))
                    getVo().successful("登录成功");
                else
                    getVo().failure("登录失败");
            }
        }, 1000);
    }
}
