package com.example.mybooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybooks.R;
import com.example.mybooks.repository.models.LikeBooks;

import java.util.ArrayList;

public class ZzimAdapter extends RecyclerView.Adapter<ZzimAdapter.ZzimViewHolder> {

    public ArrayList<LikeBooks> likeList = new ArrayList<>();

    public void initLikeList(ArrayList<LikeBooks> likeList) {
        this.likeList = likeList;
        notifyDataSetChanged();
    }

    public void addLikeList(ArrayList<LikeBooks> likeList) {
        likeList.addAll(likeList.size(), likeList);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ZzimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.best_item, parent, false);
        return new ZzimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZzimAdapter.ZzimViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // 내부클래스
    public class ZzimViewHolder extends RecyclerView.ViewHolder {





        public ZzimViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
