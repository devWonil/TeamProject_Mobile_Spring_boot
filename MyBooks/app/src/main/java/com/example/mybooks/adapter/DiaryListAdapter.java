package com.example.mybooks.adapter;

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


    ArrayList<Diary> diaryList = new ArrayList<>();

    public void initDiaryList(ArrayList<Diary> diaryList) {
        this.diaryList = diaryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.diary_item, parent, false);
        return new DiaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryViewHolder holder, int position) {
        Diary diary = diaryList.get(position);
        holder.diaryTitleTextView.setText(diary.diaryTitle);
        holder.diaryDateTextView.setText(diary.currentDate);
        holder.diaryContentTextView.setText(diary.diaryContent);
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }


    // 내부클래스
    public static class DiaryViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private TextView diaryTitleTextView;
        private TextView diaryDateTextView;
        private TextView diaryContentTextView;

        public DiaryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            diaryTitleTextView = itemView.findViewById(R.id.diaryTitleTextView);
            diaryDateTextView = itemView.findViewById(R.id.diaryDateTextView);
            diaryContentTextView = itemView.findViewById(R.id.diaryContentTextView);
        }
    }
}
