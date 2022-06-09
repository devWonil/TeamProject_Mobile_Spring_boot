package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GenreFragment extends Fragment {

    public GenreFragment() {
        // Required empty public constructor
    }

    public static GenreFragment newInstance() {
        GenreFragment fragment = new GenreFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_genre, container, false);
    }
}