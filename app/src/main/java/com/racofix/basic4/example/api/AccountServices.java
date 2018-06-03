package com.racofix.basic4.example.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountServices {
    @POST("api/user/login")
    Call<RepoList<String>> login(@Body Map map);
}
