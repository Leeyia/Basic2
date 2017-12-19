package android.arch.network.req;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;

import static android.arch.network.NonNull.checkNotNull;

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

public final class HttpRequest {

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

        public Builder baseUri(@NonNull String baseUri) {
            checkNotNull(baseUri, "baseUri == null");
            this.baseUri = baseUri;
            return this;
        }

        public Builder client(@NonNull OkHttpClient httpClient) {
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
