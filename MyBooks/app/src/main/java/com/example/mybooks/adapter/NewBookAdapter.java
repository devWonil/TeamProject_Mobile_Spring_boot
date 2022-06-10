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
import com.example.mybooks.repository.models.Book;
import com.example.mybooks.interfaces.IAdapter;
import com.example.mybooks.R;

import java.util.ArrayList;

public class NewBookAdapter extends RecyclerView.Adapter<NewBookAdapter.MyViewHolder> implements IAdapter {

    private ArrayList<Book> newBookList = new ArrayList<>();

    @Override
    public void initBookList(ArrayList<Book> list) {
        this.newBookList = list;
    }

    @Override
    public void addBookList(ArrayList<Book> list) {
        newBookList.addAll(newBookList.size(), list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = newBookList.get(position);

        Glide.with(holder.newBookImageView.getContext())
                .load(book.getImageUrl())
                .placeholder(R.drawable.image_loading)
                .transform(new CenterInside())
                .into(holder.newBookImageView);

        holder.newBookTitleTextView.setText(book.getTitle());
        holder.newBookAuthorTextView.setText(book.getAuthor());
        holder.newBookPublisherTextView.setText(book.getPublisher());
        holder.newBookPriceTextView.setText(String.valueOf(book.getPrice()));

    }

    @Override
    public int getItemCount() {
        return newBookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView newBookImageView;
        TextView newBookTitleTextView;
        TextView newBookAuthorTextView;
        TextView newBookPublisherTextView;
        TextView newBookPriceTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            newBookImageView = itemView.findViewById(R.id.newBookImageView);
            newBookTitleTextView = itemView.findViewById(R.id.newBookTitleTextView);
            newBookAuthorTextView = itemView.findViewById(R.id.newBookAuthorTextView);
            newBookPublisherTextView = itemView.findViewById(R.id.newBookPublisherTextView);
            newBookPriceTextView = itemView.findViewById(R.id.newBookPriceTextView);
        }
    }

}
