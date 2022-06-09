package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class BookDetailActivity extends AppCompatActivity {

    private ImageButton likeBtn;
    private ImageButton likeBtnClicked;
    private Button purchaseBtn;
    private boolean btnCliked = false;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        likeBtn = findViewById(R.id.likeBtn);
        likeBtnClicked = findViewById(R.id.likeBtnClicked);
        purchaseBtn = findViewById(R.id.purchaseBtn);

        // 프래그먼트 생성
        likeBtn.setOnClickListener(view -> {
            fragment = new Fragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.likeBtn, fragment);
            transaction.commit();
            btnCliked = true;
        });
    }
}