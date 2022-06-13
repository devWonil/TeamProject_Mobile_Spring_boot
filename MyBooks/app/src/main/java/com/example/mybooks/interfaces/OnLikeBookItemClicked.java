package com.example.mybooks.interfaces;

import com.example.mybooks.repository.models.LikeBooks;

public interface OnLikeBookItemClicked {
    void selectItem(LikeBooks books);
}
