package com.nenton.gamesofthrones.data.network.interceptors;


import com.nenton.gamesofthrones.data.manager.DataManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class Header implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Cache-Control", "max-age=" + (60 * 60 * 24));

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
