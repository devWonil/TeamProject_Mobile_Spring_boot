package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ZzimFragment extends Fragment {



    public ZzimFragment() {
        // Required empty public constructor
    }


    public static ZzimFragment newInstance() {
        ZzimFragment fragment = new ZzimFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zzim, container, false);
    }


}