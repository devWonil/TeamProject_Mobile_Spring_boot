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
import com.example.mybooks.models.Book;

import com.example.mybooks.interfaces.IAdapter;
import com.example.mybooks.interfaces.OnBookItemClicked;
import com.example.mybooks.R;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.MyViewHolder> implements IAdapter {

    private ArrayList<Book> bookList = new ArrayList<>();
    private OnBookItemClicked onBookItemClicked;

    public void setOnBookItemClicked(OnBookItemClicked onBookItemClicked) {
        this.onBookItemClicked = onBookItemClicked;
    }

    @Override
    public void initBookList(ArrayList<Book> list) {
        this.bookList = list;
    }

    @Override
    public void addBookList(ArrayList<Book> list) {
        bookList.addAll(bookList.size(), list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.best_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = bookList.get(position);

        Glide.with(holder.bestBookImageView.getContext())
                .load(book.getImageUrl())
                .placeholder(R.drawable.image_loading)
                .transform(new CenterInside())
                .into(holder.bestBookImageView);

        holder.bestNumberTextView.setText(String.valueOf(position + 1));
        holder.bestBookTitleTextView.setText(book.getTitle());
        holder.bestBookAuthorTextView.setText(book.getAuthor());
        holder.bestBookPublisherTextView.setText(book.getPublisher());
        holder.bestBookPriceTextView.setText(String.valueOf(book.getPrice()));
        holder.bestBookRatingTextView.setText(String.valueOf(book.getRating()));

        holder.setItem(book);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView bestBookImageView;
        TextView bestNumberTextView;
        TextView bestBookTitleTextView;
        TextView bestBookAuthorTextView;
        TextView bestBookPublisherTextView;
        TextView bestBookPriceTextView;
        TextView bestBookRatingTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bestBookImageView = itemView.findViewById(R.id.bestBookImageView);
            bestNumberTextView = itemView.findViewById(R.id.bestNumberTextView);
            bestBookTitleTextView = itemView.findViewById(R.id.bestBookTitleTextView);
            bestBookAuthorTextView = itemView.findViewById(R.id.bestBookAuthorTextView);
            bestBookPublisherTextView = itemView.findViewById(R.id.bestBookPublisherTextView);
            bestBookPriceTextView = itemView.findViewById(R.id.bestBookPriceTextView);
            bestBookRatingTextView = itemView.findViewById(R.id.bestBookRatingTextView);
        }

        public void setItem(Book book) {
            Glide.with(bestBookImageView.getContext())
                    .load(book.getImageUrl())
                    .placeholder(R.drawable.book)
                    .into(bestBookImageView);

            bestBookTitleTextView.setText(book.getTitle());
            bestBookAuthorTextView.setText(book.getAuthor());

            // 오류 String type :
            bestBookPriceTextView.setText(String.valueOf(book.getPrice()));
            bestBookImageView.setOnClickListener(view -> {
                onBookItemClicked.selectItem(book);
            });

        }
    }

}
