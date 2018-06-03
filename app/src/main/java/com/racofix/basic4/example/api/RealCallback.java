package com.racofix.basic4.example.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RealCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (isSuccessful(response.code()))
            RealCallback.this.successfully(response);
        else
            RealCallback.this.onFailure(response.errorBody().toString());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RealCallback.this.onFailure(t.getMessage());
    }

    public abstract void successfully(Response<T> response);

    public void onFailure(String message) {
    }

    private boolean isSuccessful(int code) {
        return code >= 200 && code <= 404;
    }
}
