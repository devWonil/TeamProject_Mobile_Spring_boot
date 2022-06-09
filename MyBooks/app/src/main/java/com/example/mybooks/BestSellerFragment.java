package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mybooks.databinding.FragmentBestSellerBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BestSellerFragment extends Fragment {

    private static BestSellerFragment bestSellerFragment;

    private ArrayList<Book> list = new ArrayList<>();

    private FragmentBestSellerBinding binding;
    private BookHttpService bookHttpService;
    private BestSellerAdapter adapter;

    private int page = 1;

    public BestSellerFragment() {

    }

    public static BestSellerFragment getInstance() {
        if (bestSellerFragment == null) {
            bestSellerFragment = new BestSellerFragment();
        }
        return bestSellerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookHttpService = BookHttpService.retrofit.create(BookHttpService.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBestSellerBinding.inflate(inflater, container, false);

        setupRecyclerView(list);

        requestBestSellerBookData();

        return binding.getRoot();
    }

    private void requestBestSellerBookData() {
        bookHttpService.getBestSellerList(page).enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                Log.d("TAG", "통신메서드안에는 들어옴");
                if (response.isSuccessful()) {
                    ArrayList<Book> addList = response.body();
                    adapter.addBookList(addList);
                    page++;
                    Log.d("TAG", "통신완료");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView(ArrayList<Book> list) {
        adapter = new BestSellerAdapter();
        adapter.initBookList(list);
        Log.d("TAG", "어댑터 생성 완료");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.bestSellerContainer.setAdapter(adapter);
        binding.bestSellerContainer.setLayoutManager(layoutManager);
    }
}