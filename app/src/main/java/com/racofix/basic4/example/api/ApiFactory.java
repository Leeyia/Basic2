package com.racofix.basic4.example.api;

import com.racofix.basic4.example.BuildConfig;
import com.racofix.http.HttpLogInterceptor;
import com.racofix.http.HttpProxy;
import com.racofix.http.HttpRequest;

import okhttp3.OkHttpClient;

public class ApiFactory {

    public static AccountServices account() {
        return servs(AccountServices.class);
    }

    private static <T> T servs(Class<T> clzz) {
        HttpRequest request = new HttpRequest.Builder()
                .baseUri("https://api.elabels.cn/v1/api/")
                .client(createClient())
                .build();
        return HttpProxy.getInstance().newRequestQueue(clzz, request);
    }

    private static OkHttpClient createClient() {
        HttpLogInterceptor logInterceptor = new HttpLogInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLogInterceptor.Level.BODY : HttpLogInterceptor.Level.NONE);
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .build();
    }
}
