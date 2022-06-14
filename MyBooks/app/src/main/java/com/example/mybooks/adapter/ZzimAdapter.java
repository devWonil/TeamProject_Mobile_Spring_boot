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
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.repository.models.LikeBooks;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ZzimAdapter extends RecyclerView.Adapter<ZzimAdapter.ZzimViewHolder> {

    public ArrayList<Book> likeList = new ArrayList<>();

    public void initLikeList(ArrayList<Book> likeList) {
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
        Book book = likeList.get(position);
        Glide.with(holder.likeImageView.getContext()).load(book.getImageUrl())
                .placeholder(R.drawable.image_loading).transform(new FitCenter(), new RoundedCorners(10))
                .into(holder.likeImageView);
        holder.likeTitleTextView.setText(book.getTitle());
        holder.likeAuthorTextView.setText(book.getAuthor());
        holder.likePriceTextView.setText(book.getPrice());
    }

    @Override
    public int getItemCount() {
        return likeList.size();
    }

    // 내부클래스
    public class ZzimViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private ImageView likeImageView;
        private TextView likeTitleTextView;
        private TextView likeAuthorTextView;
        private TextView likePriceTextView;

        public ZzimViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            likeImageView = itemView.findViewById(R.id.likeItemImageView);
            likeTitleTextView = itemView.findViewById(R.id.likeItemTitle);
            likeAuthorTextView = itemView.findViewById(R.id.likeItemAuthor);
            likePriceTextView = itemView.findViewById(R.id.likeItemPrice);
        }
    }
}
