package com.tolmach.testtask;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RickAndMortyInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .build();

        request = request
                .newBuilder()
                .url(url)
                .build();

        return chain.proceed(request);
    }
}
