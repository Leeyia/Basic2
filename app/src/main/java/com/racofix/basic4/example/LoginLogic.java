package com.racofix.basic4.example;

import com.racofix.persistence.BaseVo;

public interface LoginLogic {

    void login(String username, String password);

    interface LoginVo extends BaseVo {
        void successful(String msg);

        void failure(String msg);
    }
}
