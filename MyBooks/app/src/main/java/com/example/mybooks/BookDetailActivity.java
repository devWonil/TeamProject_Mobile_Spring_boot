package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mybooks.databinding.ActivityBookDetailBinding;
import com.example.mybooks.models.Book;
import com.example.mybooks.retrofit.BookHttpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailActivity extends AppCompatActivity {

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

            binding.likeButton.setOnClickListener(v -> {
                SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
                boolean isFavorite = sp.getBoolean("isFavorite", !(book.isFavorite()));

                if (MainActivity.likeBookList.size() == 0) {
                    Toast.makeText(this, "찜 목록에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    MainActivity.likeBookList.add(book);
                    binding.likeButton.setChecked(true);
                } else {
                    for (int i = 0; i < MainActivity.likeBookList.size(); i++) {
                        if (MainActivity.likeBookList.get(i).getImageUrl().equals(book.getImageUrl())) {
                            Toast.makeText(this, "찜 목록에 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            MainActivity.likeBookList.remove(i);
                            return;
                        }
                    }
                    Toast.makeText(this, "찜 목록에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    MainActivity.likeBookList.add(book);
                    Log.d("TAG", MainActivity.likeBookList.size() + "");
                }
            });
        }
    }

    public void onPurchaseBtnClicked(View view) { // 구매버튼 클릭 메소드
        // 여기에 구매 URL
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}