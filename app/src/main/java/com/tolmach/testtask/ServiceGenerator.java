package com.tolmach.testtask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static final String REQUEST_TYPE = "json";

    ServiceGenerator(){
        rickAndMortyClient = createService(RickAndMortyClient.class);
    }

    private final String BASE_URL = "https://rickandmortyapi.com/api/";
    private Type artistType = new TypeToken<List<Character>>(){}.getType();

    private  HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private OkHttpClient httpClient =
            new OkHttpClient.Builder().addInterceptor(logging)
                    .addInterceptor(new RickAndMortyInterceptor()).build();

    private  Gson gson = new GsonBuilder()
            .registerTypeAdapter(artistType, new CharacterDeserializer())
            .create();

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private  Retrofit retrofit = builder.build();

    private <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)){
            retrofit = builder.build();
            builder.client(httpClient);
        }
        return retrofit.create(serviceClass);
    }

    private RickAndMortyClient rickAndMortyClient;
    public RickAndMortyClient getRickAndMortyClient(){
        return rickAndMortyClient;
    }

    public static ServiceGenerator getInstance(){
        if (instance == null) {
            instance = new ServiceGenerator();
        }
        return instance;
    }

    private static ServiceGenerator instance;

}
