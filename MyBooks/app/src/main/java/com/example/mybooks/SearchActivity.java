package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mybooks.adapter.SearchBookAdapter;
import com.example.mybooks.databinding.ActivitySearchBinding;
import com.example.mybooks.interfaces.IBookFragment;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.retrofit.BookHttpService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements IBookFragment, OnBookItemClicked {

    ActivitySearchBinding binding;
    private RecyclerView searchBookContainer;
    private BookHttpService bookHttpService;
    private SearchBookAdapter searchBookAdapter;
    private ArrayList<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bookHttpService = BookHttpService.retrofit.create(BookHttpService.class);
        setupRecyclerView(bookList);
        requestBookData();
        binding.searchView.setSubmitButtonEnabled(true);
        binding.searchView.setMaxWidth(Integer.MAX_VALUE);
    }


    @Override
    public void requestBookData() {
        binding.searchView.
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 검색 버튼이 눌러졌을 때 이벤트 처리
                if(binding.searchView.getQuery().equals("")) {
                    Toast.makeText(SearchActivity.this, "제목을 입력해주세요", Toast.LENGTH_SHORT).show();
                return false;
                } 
                
                String searchText = binding.searchView.getQuery().toString().replace(" ", "").toUpperCase();
                bookHttpService.getSearchList(searchText).enqueue(new Callback<ArrayList<Book>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() == 0) {
                                // recyclerView 다시 그려줌
                                searchBookAdapter.setBookList(bookList);
                                searchBookAdapter.notifyDataSetChanged();
                                Toast.makeText(SearchActivity.this, "검색하신 제목의 책이 없습니다", Toast.LENGTH_SHORT).show();
                            } else {
                                ArrayList<Book> addList = response.body();
                                searchBookAdapter.initSearchBookList(addList);
                            }
                            Log.d("TAG", "통신 성공");
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Book>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void setupRecyclerView(ArrayList<Book> list) {
        searchBookAdapter = new SearchBookAdapter();
        // 이벤트 리스너
        searchBookAdapter.setOnBookItemClicked(this);
        searchBookAdapter.initSearchBookList(list);
        Log.d("TAG", "어댑터 성공");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.searchBookContainer.setAdapter(searchBookAdapter);
        binding.searchBookContainer.hasFixedSize();
        binding.searchBookContainer.setLayoutManager(layoutManager);
    }

    @Override
    public void selectItem(Book book) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.PARAM_NAME_1, book);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (!binding.searchView.isIconified()) {
            binding.searchView.setIconified(true);
        } else {
            super.onBackPressed();
        }
    }
}