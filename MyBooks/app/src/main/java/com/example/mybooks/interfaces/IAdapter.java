package com.example.mybooks.interfaces;

import com.example.mybooks.repository.models.Book;

import java.util.ArrayList;

public interface IAdapter {
    void initBookList(ArrayList<Book> list);
    void addBookList(ArrayList<Book> list);
}
