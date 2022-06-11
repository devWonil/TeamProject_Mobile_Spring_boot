package com.example.mybooks;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.NewBookAdapter;
import com.example.mybooks.databinding.FragmentNewBinding;
import com.example.mybooks.interfaces.IBookFragment;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.retrofit.BookHttpService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewFragment extends Fragment implements IBookFragment, OnBookItemClicked {

    private static NewFragment newFragment;

    private ArrayList<Book> list = new ArrayList<>();

    private FragmentNewBinding binding;
    private BookHttpService bookHttpService;
    private NewBookAdapter adapter;

    private int page = 1;
    private boolean isRequest = true;

    public NewFragment() {
        // Required empty public constructor
    }

    public static NewFragment getInstance() {
        if (newFragment == null) {
            newFragment = new NewFragment();
        }
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookHttpService = BookHttpService.retrofit.create(BookHttpService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewBinding.inflate(inflater, container, false);

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
        adapter = new NewBookAdapter();
        adapter.initBookList(list);
        adapter.setOnBookItemClicked(this);
        binding.newBookContainer.setAdapter(adapter);

        binding.newBookContainer.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

            if (isRequest) {
                LinearLayoutManager manager = (LinearLayoutManager) binding.newBookContainer.getLayoutManager();
                int lastVisibleBookItemCount = manager.findLastVisibleItemPosition();
                int bookTotalCount = binding.newBookContainer.getAdapter().getItemCount() - 1;

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
        intent.putExtra(BookDetailActivity.PARAM_NAME_1, book);
        startActivity(intent);
    }
}