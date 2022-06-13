package com.example.mybooks.retrofit;

import com.example.mybooks.repository.models.Book;

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

    @GET("new-book/")
    Call<ArrayList<Book>> getNewBookList(
            @Query("page") int page
    );

    @GET("genre/")
    Call<ArrayList<Book>> getGenreList(
            @Query("page") int page,
            @Query("themeNumber") int themeNumber
    );

    @GET("random/")
    Call<ArrayList<Book>> getRandomList(
    );
}
