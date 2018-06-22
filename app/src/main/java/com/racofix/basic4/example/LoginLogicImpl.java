package com.racofix.basic4.example;

import android.os.Handler;
import android.util.Log;

import com.racofix.logic.LogicImpl;
import com.racofix.basic4.example.api.ApiFactory;
import com.racofix.basic4.example.api.RealCallback;
import com.racofix.basic4.example.api.RepoList;

import java.util.HashMap;

import retrofit2.Response;

public class LoginLogicImpl extends LogicImpl<LoginLogic.LoginVo> implements LoginLogic {

    @Override
    public void login(final String username, final String password) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", username);
        ApiFactory.account().login(map).enqueue(new RealCallback<RepoList<String>>() {
            @Override
            public void successfully(Response<RepoList<String>> response) {

            }
        });

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

    @Override
    public void onLogicCreated() {
        super.onLogicCreated();
        Log.d("LoginLogicImpl", "LoginLogicImpl onCreate");
    }

    @Override
    public void onLogicDestroy() {
        super.onLogicDestroy();
        Log.d("LoginLogicImpl", "LoginLogicImpl onDestroy");
    }
}
