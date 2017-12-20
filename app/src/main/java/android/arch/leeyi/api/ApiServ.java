package android.arch.leeyi.api;
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

import android.arch.leeyi.db.Ro;
import android.arch.network.rep.Repo;
import android.arch.leeyi.db.Token;
import android.arch.lifecycle.LiveData;
import android.arch.network.req.ReqMap;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServ {

    @POST("user/login/?from=pda")
    LiveData<Repo<Ro<Token>>> login(@Body ReqMap mReqMap);
}
