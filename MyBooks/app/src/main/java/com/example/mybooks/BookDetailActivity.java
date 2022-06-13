package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mybooks.databinding.ActivityBookDetailBinding;
import com.example.mybooks.repository.models.Book;

public class BookDetailActivity extends AppCompatActivity {

    private ScaleAnimation scaleAnimation;
    //애니메이션이 일어나는 동안의 회수, 속도를 조절하거나 시작과 종료시의 효과를 추가 할 수 있다
    private BounceInterpolator bounceInterpolator;
    private CompoundButton likeButton; // 찜 버튼
    private Button purchaseBtn; // 구매하기 버튼
    private ImageView bookImage; // 책이미지
    private TextView bookTitle; // 책제목
    private TextView author; // 작가
    private TextView publishDate; // 출판일
    private TextView summaryText; // 줄거리 내용

    private Book book;
    public static final String PARAM_NAME_1 = "book obj";
    private ActivityBookDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent() != null) {
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

    private void initData() {
        Glide.with(this)
                .load(book.getImageUrl()).fitCenter()
                .into(binding.bookImage);

        binding.bookTitle.setText(book.getTitle());
        binding.author.setText(book.getAuthor());
        binding.publishDate.setText(book.getPublicationDate());
        binding.summaryText.setText(book.getIntro());

        if (book.isFavorite() == false) {
            binding.likeButton.setChecked(false);
        } else {
            binding.likeButton.setChecked(true);
        }

        Log.d("TAG", String.valueOf(book.isFavorite()));

        // 장르
        switch (book.getTheme()) {
            case 1:
                binding.genre.setText("소설");
                break;
            case 2:
                binding.genre.setText("추리");
                break;
            case 3:
                binding.genre.setText("에쎄이");
                break;
            case 4:
                binding.genre.setText("자기계발");
                break;
            case 5:
                binding.genre.setText("경제");
                break;
            case 6:
                binding.genre.setText("기타");
                break;
            case 7:
                binding.genre.setText("어린이");
                break;
        }

        // 출판사
        binding.publishCompany.setText(book.getPublisher());
        // 가격
        binding.bookPrice.setText(String.valueOf(book.getPrice()));
        // 별점
        binding.ratingBar.setRating((float) book.getRating());

    }

    private void addEventListener() {
        binding.likeButton.setOnClickListener(v -> {
            if (book.isFavorite() == false) {
                book.setFavorite(true);
//                binding.likeButton.setChecked(true);
            } else {
                book.setFavorite(false);
            }
            Log.d("TAG", String.valueOf(book.isFavorite()));

        });
    }

}