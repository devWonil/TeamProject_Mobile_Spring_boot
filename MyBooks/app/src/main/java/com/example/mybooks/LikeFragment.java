package com.example.mybooks;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.LikeBookAdapter;
import com.example.mybooks.databinding.FragmentLikeBinding;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.models.Book;

public class LikeFragment extends Fragment implements OnBookItemClicked {

    private FragmentLikeBinding binding;
    private LikeBookAdapter adapter;

    public LikeFragment() {

    }

    public static LikeFragment newInstance() {
        LikeFragment fragment = new LikeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLikeBinding.inflate(inflater, container, false);
        setRecyclerView();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.likeRefreshButton.setOnClickListener(v -> {
            adapter.addLikeList(MainActivity.likeBookList);
        });
        binding.likeRefreshButton.callOnClick();
    }

    private void setRecyclerView() {
        adapter = new LikeBookAdapter();
        adapter.addLikeList(MainActivity.likeBookList);
        adapter.setOnBookItemClicked(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.likeBookContainer.setAdapter(adapter);
        binding.likeBookContainer.setLayoutManager(layoutManager);
    }

    @Override
    public void selectItem(Book book) {
        Intent intent = new Intent(getContext(), BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.PARAM_NAME_1, book);
        startActivity(intent);
    }
}