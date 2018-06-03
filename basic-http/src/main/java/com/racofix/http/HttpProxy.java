package com.racofix.http;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class HttpProxy {
    
    private static HttpProxy mHttp;
    private Map<Class, Object> m_service = new HashMap<>();

    private HttpProxy() {
    }

    public static HttpProxy getInstance() {
        if (mHttp == null)
            synchronized (HttpProxy.class) {
                if (mHttp == null) mHttp = new HttpProxy();
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
