package com.example.mybooks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
        binding = FragmentDiaryHomeBinding.inflate(inflater, container, false);
        setDiaryRecyclerView();
        return binding.getRoot();
    }

    public void setDiaryRecyclerView() {
        // TODO 이벤트 리스너 등록
        diaryListAdapter = new DiaryListAdapter();
        diaryListAdapter.initDiaryList(diaryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.diaryListContainer.setAdapter(diaryListAdapter);
        binding.diaryListContainer.setLayoutManager(layoutManager);

    }

}