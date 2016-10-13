package com.nenton.gamesofthrones.data.network;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.nenton.gamesofthrones.data.network.interceptors.Header;
import com.nenton.gamesofthrones.utils.GOTAplication;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGen {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final String BASE_URL = "http://www.anapioficeandfire.com/api/";

    private static  Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(new Header());
        httpClient.addInterceptor(logging);
        httpClient.addNetworkInterceptor(new StethoInterceptor());
//        httpClient.cache(new Cache(GOTAplication.getContext().getCacheDir(),Integer.MAX_VALUE));

        Retrofit retrofit = sBuilder
                .client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);
    }
}
