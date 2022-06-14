package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.LikeBookAdapter;
import com.example.mybooks.databinding.FragmentLikeBinding;

public class LikeFragment extends Fragment {

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

    private void setRecyclerView() {
        adapter = new LikeBookAdapter();
        adapter.initLikeList(MainActivity.likeBookList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.likeBookContainer.setAdapter(adapter);
        binding.likeBookContainer.setLayoutManager(layoutManager);

    }
}