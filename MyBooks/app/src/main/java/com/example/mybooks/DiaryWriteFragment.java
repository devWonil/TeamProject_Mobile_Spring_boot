package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.databinding.ActivityDiaryWriteBinding;
import com.example.mybooks.databinding.FragmentDiaryWriteBinding;

public class DiaryWriteFragment extends Fragment {

    private ActivityDiaryWriteBinding binding;

    public DiaryWriteFragment() {

    }

    public static DiaryWriteFragment newInstance() {
        DiaryWriteFragment fragment = new DiaryWriteFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ActivityDiaryWriteBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


}