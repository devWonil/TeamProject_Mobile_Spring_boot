package com.example.mybooks;

import java.util.ArrayList;

public interface IBookFragment {
    default void requestBookData(){};
    void setupRecyclerView(ArrayList<Book> list);
}
