package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.DiaryListAdapter;
import com.example.mybooks.databinding.FragmentDiaryHomeBinding;
import com.example.mybooks.repository.models.Diary;

import java.util.ArrayList;

public class DiaryHomeFragment extends Fragment {

    private FragmentDiaryHomeBinding binding;
    private static DiaryHomeFragment diaryFragment;
    private DiaryListAdapter diaryListAdapter;

    private ArrayList<Diary> diaryList = new ArrayList<>();

    public DiaryHomeFragment() {
        // Required empty public constructor
    }

    public static DiaryHomeFragment newInstance() {
        DiaryHomeFragment fragment = new DiaryHomeFragment();
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
        return inflater.inflate(R.layout.fragment_diary_home, container, false);
    }

    public void setDiaryRecyclerView() {
        diaryListAdapter = new DiaryListAdapter();
//        diaryListAdapter.initDiaryList();
    }

}