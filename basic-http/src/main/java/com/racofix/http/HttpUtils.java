package com.racofix.http;

import android.support.annotation.NonNull;

final class HttpUtils {

    static @NonNull <T> T checkNotNull(final T reference, final Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }
}
