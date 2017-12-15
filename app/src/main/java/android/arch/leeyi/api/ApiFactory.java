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

import android.arch.network.rep.HttpLogInterceptor;
import android.arch.network.req.HttpProxyImpl;
import android.arch.network.req.HttpRequest;

import okhttp3.OkHttpClient;

public class ApiFactory {

    private static HttpRequest request;

    public static ApiServ serv() {
        return servs(ApiServ.class);
    }

    /*生成对应的Services*/
    private static <T> T servs(Class<T> clzz) {
        if (request == null)
            request = new HttpRequest.Builder()
                    .baseUri("http://192.168.2.219/")
                    .develop(true)
                    .client(createClient())
                    .build();
        return HttpProxyImpl.getInstance().newRequestQueue(clzz, request);
    }

    private static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLogInterceptor().setLevel(HttpLogInterceptor.Level.BODY))
                .build();
    }
}
