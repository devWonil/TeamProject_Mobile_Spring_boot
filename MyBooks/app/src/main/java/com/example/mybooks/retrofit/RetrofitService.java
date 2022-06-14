package com.example.mybooks.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    // http://localhost:9090/mybooks/best-celler/title
    @GET("title")
    Call<ArrayList<LikeBooks>> getTitles();

    // http://localhost:9090/mybooks/best-celler/author
    @GET("author")
    Call<ArrayList<LikeBooks>> getAuthors();
}
