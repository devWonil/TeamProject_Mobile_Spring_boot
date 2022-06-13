package com.example.mybooks.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybooks.R;
import com.example.mybooks.repository.models.Diary;

import java.util.ArrayList;

public class DiaryListAdapter extends RecyclerView.Adapter<DiaryListAdapter.DiaryViewHolder> {

    public ArrayList<Diary> diaryList = new ArrayList<>();

    public void initDiaryList(ArrayList<Diary> diaryList) {
        this.diaryList = diaryList;
        notifyDataSetChanged();
    }

    public void addDiaryList(ArrayList<Diary> list) {
        diaryList.addAll(diaryList.size(), list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_diary, parent, false);
        return new DiaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryViewHolder holder, int position) {
        Diary diary = diaryList.get(position);
        holder.setItem(diary);
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }

    // 내부클래스
    public class DiaryViewHolder extends RecyclerView.ViewHolder {

        private TextView diaryTitleTextView;
        private TextView diaryDateTextView;
        private TextView diaryContentTextView;

        public DiaryViewHolder(@NonNull View view) {
            super(view);

            diaryTitleTextView = view.findViewById(R.id.diaryTitleTextView);
            diaryDateTextView = view.findViewById(R.id.diaryDateTextView);
            diaryContentTextView = view.findViewById(R.id.diaryContentTextView);
        }

        public void setItem(Diary diary) {
            diaryTitleTextView.setText(diary.diaryTitle);
            diaryDateTextView.setText(diary.currentDate);
            diaryContentTextView.setText(diary.diaryContent);
        }
    }
}
