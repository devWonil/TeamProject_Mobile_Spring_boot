package com.example.mybooks;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mybooks.adapter.BestSellerAdapter;
import com.example.mybooks.databinding.FragmentBestSellerBinding;
import com.example.mybooks.interfaces.IBookFragment;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.repository.models.LikeBooks;
import com.example.mybooks.retrofit.BookHttpService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BestSellerFragment extends Fragment implements IBookFragment, OnBookItemClicked {

    private static BestSellerFragment bestSellerFragment;

    private ArrayList<Book> list = new ArrayList<>();

    private FragmentBestSellerBinding binding;
    private BookHttpService bookHttpService;
    private BestSellerAdapter adapter;

    private int page = 1;
    private boolean isRequest = true;

    public BestSellerFragment() {

    }

//    public static BestSellerFragment getInstance() {
//        if (bestSellerFragment == null) {
//            bestSellerFragment = new BestSellerFragment();
//        }
//        return bestSellerFragment;

    public static BestSellerFragment newInstance() {
        BestSellerFragment fragment = new BestSellerFragment();
        return fragment;
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

        requestBookData();

        return binding.getRoot();
    }

    @Override
    public void requestBookData() {
        bookHttpService.getBestSellerList(page).enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {

                if (response.isSuccessful()) {
                    ArrayList<Book> addList = response.body();
                    adapter.addBookList(addList);
                    page++;
                    isRequest = true;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupRecyclerView(ArrayList<Book> list) {
        adapter = new BestSellerAdapter();
        adapter.setOnBookItemClicked(this); // 추가
        adapter.initBookList(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.bestSellerContainer.setAdapter(adapter);
        binding.bestSellerContainer.setLayoutManager(layoutManager);

        binding.bestSellerContainer.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

            if (isRequest) {
                LinearLayoutManager manager = (LinearLayoutManager) binding.bestSellerContainer.getLayoutManager();
                int lastVisibleBookItemCount = manager.findLastVisibleItemPosition();
                int bookTotalCount = binding.bestSellerContainer.getAdapter().getItemCount() - 1;

                if (lastVisibleBookItemCount == bookTotalCount) {
                    requestBookData();
                    isRequest = false;
                }
            }
        });
    }

    @Override
    public void selectItem(Book book) {
        Intent intent = new Intent(getContext(), BookDetailActivity.class);
        // 직렬화
        intent.putExtra(BookDetailActivity.PARAM_NAME_1, book);
        startActivity(intent);
    }


}