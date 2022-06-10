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
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.R;

import java.util.ArrayList;
import java.util.List;

public class RandomBookAdapter extends RecyclerView.Adapter<RandomBookAdapter.RandomViewHolder>{

    private List<Book> bookList = new ArrayList<>();
    
    // TODO 버튼 이벤트 등록하여 세부정보 볼 수 있게 하기
    // TODO 콜백 메서드

    public void initBookList(List<Book> list) {
        this.bookList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_book, parent, false);
        return new RandomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.titleTextView.setText(book.getTitle());
        Glide.with(holder.bookImageView.getContext()).load(book.getImageUrl())
                .placeholder(R.drawable.image_loading).transform(new FitCenter(), new RoundedCorners(10))
                .into(holder.bookImageView);
        holder.itemView.setOnClickListener(v -> {
            // 이벤트 리스너
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class RandomViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView bookImageView;
        private TextView titleTextView;

        public RandomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            bookImageView = itemView.findViewById(R.id.bookImageView);
            titleTextView = itemView.findViewById(R.id.bookTitleTextView);
        }

    }
}
