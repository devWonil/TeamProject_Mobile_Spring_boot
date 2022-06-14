package com.example.mybooks.interfaces;

import com.example.mybooks.models.Book;

import java.util.ArrayList;

public interface IBookFragment {
    default void requestBookData(){};
    void setupRecyclerView(ArrayList<Book> list);
}
