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
import com.example.mybooks.repository.models.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchBookAdapter extends RecyclerView.Adapter<SearchBookAdapter.SearchViewHolder> {

    private List<Book> bookList = new ArrayList<>();

    private OnBookItemClicked onBookItemClicked;
    public void setOnBookItemClicked(OnBookItemClicked onBookItemClicked) {
        this.onBookItemClicked = onBookItemClicked;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void initSearchBookList(List<Book> list) {
        this.bookList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_search_book, parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Book book = bookList.get(position);
        Glide.with(holder.searchImageView.getContext()).load(book.getImageUrl())
                .placeholder(R.drawable.image_loading).transform(new FitCenter(), new RoundedCorners(10))
                .into(holder.searchImageView);
        holder.searchTitleTextView.setText(book.getTitle());
        holder.searchAuthorTextView.setText(book.getAuthor());
        // 아이템 클릭시 설정
        holder.itemView.setOnClickListener(v -> {
            onBookItemClicked.selectItem(book);
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView searchImageView;
        private TextView searchTitleTextView;
        private TextView searchAuthorTextView;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            searchImageView = itemView.findViewById(R.id.searchBookImageView);
            searchTitleTextView = itemView.findViewById(R.id.searchBookTitle);
            searchAuthorTextView = itemView.findViewById(R.id.searchBookAuthor);
        }
    }
}
