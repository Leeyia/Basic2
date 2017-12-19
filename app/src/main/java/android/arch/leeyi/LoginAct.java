package android.arch.leeyi;
/*
 * Copyright (C) 2017 meikoz, http://basic2it.cc/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.arch.leeyi.db.Token;
import android.arch.lifecycle.Observer;
import android.arch.network.rep.Resource;
import android.arch.network.req.ReqMap;
import android.arch.support.app.AbsLifecycleActy;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class LoginAct extends AbsLifecycleActy implements View.OnClickListener {

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);
        findViewById(R.id.req).setOnClickListener(this);

        viewModel = getViewModel(LoginViewModel.class, LoginViewModel.create());
    }

    @Override
    public void onClick(View view) {
        ReqMap requMap = new ReqMap()
                .put("username", "17710928693")
                .put("password", "1234@abcd");

        viewModel
                .login(requMap)
                .observe(this, new Observer<Resource<Token>>() {
                    @Override
                    public void onChanged(@Nullable Resource<Token> tokenResource) {
                        Log.d("token", "onChange =" + tokenResource.data.toString());
                        showToast("token");
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OkHttp", "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OkHttp", "onDestroy()");
    }
}
