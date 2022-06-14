package com.example.mybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.mybooks.databinding.ActivityDiaryWriteBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryWriteActivity extends AppCompatActivity {

    private ActivityDiaryWriteBinding binding;

    public static final String DIARY_DATABASE = "diaryDatabase";
    public static final String DIARY_NUMBER = "diaryNumber";
    public static final String DIARY_TITLE = "diaryTitle";
    public static final String DIARY_CONTENT = "diaryContent";
    public static final String CURRENT_DATE = "currentDate";
    private SharedPreferences diaryDb;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDiaryWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        diaryDb = getSharedPreferences(DIARY_DATABASE, MODE_PRIVATE);
        editor = diaryDb.edit();

        setSupportActionBar(binding.diaryToolbar);
        addEventListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.diary_tool_bar, menu);
        Log.d("TAG", "메뉴 이벤트");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveIcon:
                int diaryNumber = Integer.parseInt(binding.diaryIdEditText.getText().toString());

                String diaryTitle = binding.diaryTitleEditText.getText().toString();
                String currentDate = getCurrentDate();
                String diaryContent = binding.diaryContentEditText.getText().toString();

                editor.putInt(DIARY_NUMBER, diaryNumber);
                editor.putString(CURRENT_DATE, currentDate);
                editor.putString(DIARY_TITLE, diaryTitle);
                editor.putString(DIARY_CONTENT, diaryContent);
                editor.apply();

                finish();
                break;
        }

        return true;
    }

    public String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    private void addEventListener(){
        binding.diaryToolbar.setNavigationOnClickListener(v -> {
            DiaryHomeFragment.newNote = false;
            finish();
        });
    }

}