package com.racofix.http;

import okhttp3.OkHttpClient;

import static com.racofix.http.HttpUtils.checkNotNull;


public class HttpRequest {

    private final String baseUri;
    private final OkHttpClient okHttpClient;
    private final boolean isDeveloped;
    private final Class serv;

    HttpRequest(Builder builder) {
        this.baseUri = builder.baseUri;
        this.okHttpClient = builder.okHttpClient;
        this.isDeveloped = builder.isDeveloped;
        this.serv = builder.serv;
    }

    public String url() {
        return baseUri;
    }

    public OkHttpClient client() {
        return okHttpClient;
    }

    public boolean develop() {
        return isDeveloped;
    }

    public Class serv() {
        return serv;
    }

    public static class Builder {
        private String baseUri;
        private OkHttpClient okHttpClient;
        private boolean isDeveloped;
        private Class serv;

        public Builder() {
            baseUri = null;
            okHttpClient = new OkHttpClient.Builder().build();
            isDeveloped = true;
        }

        public Builder baseUri(String baseUri) {
           checkNotNull(baseUri, "baseUri == null");
            this.baseUri = baseUri;
            return this;
        }

        public Builder client(OkHttpClient httpClient) {
            checkNotNull(baseUri, "OkHttpClient == null");
            this.okHttpClient = httpClient;
            return this;
        }

        public Builder develop(boolean isDeveloped) {
            this.isDeveloped = isDeveloped;
            return this;
        }

        public Builder serv(Class clzz) {
            checkNotNull(baseUri, "serv class == null");
            this.serv = clzz;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
