package com.example.mybooks;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookHttpService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:9090/mybooks/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("best-seller/")
    Call<ArrayList<Book>> getBestSellerList(
            @Query("page") int page
    );

    @GET("genre/")
    Call<ArrayList<Book>> getGenreList(
            @Query("page") int page,
            @Query("themeNumber") int themeNumber
    );
}
