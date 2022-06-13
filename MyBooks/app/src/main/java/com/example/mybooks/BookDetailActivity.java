package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.mybooks.databinding.ActivityBookDetailBinding;
import com.example.mybooks.repository.models.Book;

public class BookDetailActivity extends AppCompatActivity {


    private ToggleButton likeButton; // 찜 버튼


    private Book book;
    public static final String PARAM_NAME_1 = "book obj";
    private ActivityBookDetailBinding binding;

    public ToggleButton getLikeButton() {
        return likeButton;
    }

    public void setLikeButton(ToggleButton likeButton) {
        this.likeButton = likeButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent() != null){
            book = (Book) getIntent().getSerializableExtra(PARAM_NAME_1);
            initData();
            addEventListener();


        }

//        setContentView(R.layout.activity_book_detail);
//
//        scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f,
//                Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f);
//
//        scaleAnimation.setDuration(500);
//        bounceInterpolator = new BounceInterpolator();
//        scaleAnimation.setInterpolator(bounceInterpolator);
//
//        likeButton = findViewById(R.id.likeButton);
//
//        likeButton.setOnCheckedChangeListener((compoundButton, isChecked) ->
//                compoundButton.startAnimation(scaleAnimation));

    }



    public void onPurchaseBtnClicked(View view) { // 구매버튼 클릭 메소드
        // 여기에 구매 URL                                           여기에 넣기!!
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(book.getBuyUrl()));
        startActivity(intent);
    }

    public void onLikeBtnClicked(View view) { // 찜버튼 클릭 메소드
        likeButton = findViewById(R.id.likeButton);

        Toast.makeText(this, "찜 하셨어요", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "value : " + likeButton.isChecked()); // true

        likeButton.setOnClickListener(v -> {
            if (likeButton.isChecked()){
                Toast.makeText(this, "찜 하셨어요", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "value : " + likeButton.isChecked()); // true
            }else {

                Toast.makeText(this, "찜 취소하셨어요", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "value : " + likeButton.isChecked()); // false
            }
        });
    }


    private void initData() {
        Glide.with(this)
                .load(book.getImageUrl())
                .into(binding.bookImage);

        binding.bookTitle.setText(book.getTitle());
        binding.author.setText(book.getAuthor());
        binding.publishDate.setText(book.getPublicationDate());
        binding.summaryText.setText(book.getIntro());


    }

    private void addEventListener() {

    }

}