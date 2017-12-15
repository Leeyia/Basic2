package android.arch.network.req;

import android.arch.network.converter.LiveDataCallAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

public final class HttpProxyImpl {

    private static HttpProxyImpl mHttp;
    private Map<Class, Object> m_service = new HashMap<>();

    private HttpProxyImpl() {
    }

    public static HttpProxyImpl getInstance() {
        if (mHttp == null)
            synchronized (HttpProxyImpl.class) {
                if (mHttp == null) mHttp = new HttpProxyImpl();
            }
        return mHttp;
    }

    /**
     * configure retrofit request params
     *
     * @param clzz    service api
     * @param request request
     * @param <T>     type
     * @return service instance
     */
    public <T> T newRequestQueue(Class<T> clzz, HttpRequest request) {
        Object serv = m_service.get(clzz);
        if (serv == null)
            synchronized (clzz) {
                serv = m_service.get(clzz);
                if (serv == null) {
                    serv = new Retrofit.Builder()
                            .baseUrl(request.url())
                            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(request.client())
                            .build()
                            .create(clzz);
                    m_service.put(clzz, serv);
                }
            }
        return (T) serv;
    }
}
