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

import android.arch.leeyi.api.ApiFactory;
import android.arch.leeyi.api.ApiServ;
import android.arch.leeyi.db.Token;
import android.arch.leeyi.db.dao.AppDatabase;
import android.arch.leeyi.db.dao.TokenDao;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.network.rep.NetworkBoundResource;
import android.arch.network.rep.Repo;
import android.arch.network.rep.Resource;
import android.arch.network.req.ReqMap;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class LoginViewModel extends ViewModel {

    private ApiServ mServ;
    private Context mContext;
    private TokenDao dao;

    private LoginViewModel(Context context) {
        this.mServ = ApiFactory.serv();
        this.mContext = context;
        this.dao = AppDatabase.getDatabase(mContext).getTokenDao();
    }

    public static LoginViewModel create(Context context) {
        return new LoginViewModel(context);
    }

    public LiveData<Resource<Token>> login(final ReqMap loginMap) {
        return new NetworkBoundResource<Token, Token>() {
            @Override
            protected void saveCallResult(@NonNull Token item) {
                dao.insert(item);
                Log.d("token", "saveCallResult =" + item.toString());
            }

            @Override
            protected boolean shouldFetch(@Nullable Token data) {
                Log.d("token", "shouldFetch =" );
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<Token> loadFromDb() {
                Log.d("token", "loadFromDb =" );
                return dao.getToken();
            }

            @NonNull
            @Override
            protected LiveData<Repo<Token>> createCall() {
                Log.d("token", "createCall()");
                return mServ.login(loginMap);
            }
        }.getLiveData();
    }
}
