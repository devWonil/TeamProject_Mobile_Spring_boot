package com.example.mybooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.interfaces.IAdapter;
import com.example.mybooks.R;

import java.util.ArrayList;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder> implements IAdapter {

    private ArrayList<Book> genreBookList = new ArrayList<>();
    private OnBookItemClicked onBookItemClicked;

    public void setOnBookItemClicked(OnBookItemClicked onBookItemClicked) {
        this.onBookItemClicked = onBookItemClicked;
    }

    public void formatBookList() {
        genreBookList.removeAll(genreBookList);
    }

    @Override
    public void initBookList(ArrayList<Book> list) {
        this.genreBookList = list;
    }

    @Override
    public void addBookList(ArrayList<Book> list) {
        genreBookList.addAll(genreBookList.size(), list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = genreBookList.get(position);

        Glide.with(holder.genreBookImageView.getContext())
                .load(book.getImageUrl())
                .placeholder(R.drawable.image_loading)
                .transform(new CenterInside())
                .into(holder.genreBookImageView);

        holder.genreBookTitleTextView.setText(book.getTitle());
        holder.genreBookAuthorTextView.setText(book.getAuthor());
        holder.genreBookPublisherTextView.setText(book.getPublisher());
        holder.genreBookPriceTextView.setText(String.valueOf(book.getPrice()));
        holder.genreBookImageView.setOnClickListener(v -> {
            onBookItemClicked.selectItem(book);
        });

    }

    @Override
    public int getItemCount() {
        return genreBookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView genreBookImageView;
        TextView genreBookTitleTextView;
        TextView genreBookAuthorTextView;
        TextView genreBookPublisherTextView;
        TextView genreBookPriceTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            genreBookImageView = itemView.findViewById(R.id.genreBookImageView);
            genreBookTitleTextView = itemView.findViewById(R.id.genreBookTitleTextView);
            genreBookAuthorTextView = itemView.findViewById(R.id.genreBookAuthorTextView);
            genreBookPublisherTextView = itemView.findViewById(R.id.genreBookPublisherTextView);
            genreBookPriceTextView = itemView.findViewById(R.id.genreBookPriceTextView);

        }
    }
}
