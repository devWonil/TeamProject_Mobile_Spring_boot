package com.example.mybooks.repository;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface RandomBookService {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http:10.0.2.2/mybooks/")
            .addConverterFactory(GsonConverterFactory.create()).build();

//    @GET("best-seller")
//    Call<>

}
