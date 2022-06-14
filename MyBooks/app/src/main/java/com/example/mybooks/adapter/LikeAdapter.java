package com.example.mybooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.mybooks.R;

import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.models.Book;


import java.util.ArrayList;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.LikeViewHolder> {

    public ArrayList<Book> likeList = new ArrayList<>();
    private OnBookItemClicked onBookItemClicked;

    public void setOnBookItemClicked(OnBookItemClicked onBookItemClicked) {
        this.onBookItemClicked = onBookItemClicked;
    }

    public void initLikeList(ArrayList<Book> likeList) {
        this.likeList = likeList;
        notifyDataSetChanged();
    }

    public void addLikeList(ArrayList<Book> likeList) {
        likeList.addAll(likeList.size(), likeList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_like, parent, false);
        return new LikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        Book book = likeList.get(position);
        Glide.with(holder.likeImageView.getContext()).load(book.getImageUrl())
                .placeholder(R.drawable.image_loading).transform(new FitCenter(), new RoundedCorners(10))
                .into(holder.likeImageView);
        holder.likeTitleTextView.setText(book.getTitle());
        holder.likeAuthorTextView.setText(book.getAuthor());
        holder.likePriceTextView.setText(String.valueOf(book.getPrice()));
        holder.itemView.setOnClickListener(v -> {
            onBookItemClicked.selectItem(book);
        });
    }

    @Override
    public int getItemCount() {
        return likeList.size();
    }

    // 내부클래스
    public class LikeViewHolder extends RecyclerView.ViewHolder {

        private ImageView likeImageView;
        private TextView likeTitleTextView;
        private TextView likeAuthorTextView;
        private TextView likePriceTextView;

        public LikeViewHolder(@NonNull View view) {
            super(view);
            likeImageView = view.findViewById(R.id.likeItemImageView);
            likeTitleTextView = view.findViewById(R.id.likeItemTitle);
            likeAuthorTextView = view.findViewById(R.id.likeItemAuthor);
            likePriceTextView = view.findViewById(R.id.likeItemPrice);
        }
    }
}
