package com.nenton.gamesofthrones.data.network;

import com.nenton.gamesofthrones.data.network.res.ListNames;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestService {

    @GET("characters?pageSize=50")
    Call<List<ListNames>> getNames(@Query("page") String pageNumber);
}