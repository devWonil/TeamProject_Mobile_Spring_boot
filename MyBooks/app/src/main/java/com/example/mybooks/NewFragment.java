package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.databinding.FragmentNewBinding;

public class NewFragment extends Fragment {

    private static NewFragment newFragment;

    private FragmentNewBinding binding;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}