package com.example.mybooks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mybooks.adapter.DiaryListAdapter;
import com.example.mybooks.databinding.FragmentDiaryHomeBinding;
import com.example.mybooks.interfaces.OnClickedSaveButton;
import com.example.mybooks.repository.models.Diary;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class DiaryHomeFragment extends Fragment {

    private FragmentDiaryHomeBinding binding;
    private static DiaryHomeFragment diaryFragment;
    private DiaryListAdapter diaryListAdapter;
    private SharedPreferences diaryDb;
    public static boolean newNote;

    private ArrayList<Diary> diaryList = new ArrayList<>();

    public DiaryHomeFragment() {
        // Required empty public constructor
    }

    public static DiaryHomeFragment newInstance() {
        if (diaryFragment == null) {
            diaryFragment = new DiaryHomeFragment();
        }
        return diaryFragment;
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
        addEventListener();
        return binding.getRoot();
    }

    public void setDiaryRecyclerView() {
        diaryListAdapter = new DiaryListAdapter();
        diaryListAdapter.initDiaryList(diaryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.diaryListContainer.setAdapter(diaryListAdapter);
        binding.diaryListContainer.setLayoutManager(layoutManager);

    }

    public void addEventListener() {
        binding.diaryWriteButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DiaryWriteActivity.class);
            startActivity(intent);
            newNote = true;
        });

        binding.refreshContainer.setOnRefreshListener(() -> {
            getDiaryDb();
            call();
            newNote = false;
            binding.refreshContainer.setRefreshing(false);
        });
    }

    public Diary getDiaryDb() {
        diaryDb = getContext().getSharedPreferences(DiaryWriteActivity.DIARY_DATABASE, Context.MODE_PRIVATE);
        int diaryNumber = diaryDb.getInt(DiaryWriteActivity.DIARY_NUMBER, -1);

        if (newNote) {
            if (diaryNumber != -1) {

                String diaryTitle = diaryDb.getString(DiaryWriteActivity.DIARY_TITLE, "제목없음");
                String currentDate = diaryDb.getString(DiaryWriteActivity.CURRENT_DATE, "날짜없음");
                String diaryContent = diaryDb.getString(DiaryWriteActivity.DIARY_CONTENT, "내용없음");

                Diary diary = new Diary(diaryNumber, diaryTitle, currentDate, diaryContent);

                return diary;
            }
        }
        return null;
    }

    public void call() {
        ArrayList<Diary> list = new ArrayList<>();
        Diary diary = getDiaryDb();

        if (diary != null) {
            list.add(diary);
            diaryListAdapter.addDiaryList(list);
        }
    }



}