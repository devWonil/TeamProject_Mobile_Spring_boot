package com.example.mybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mybooks.databinding.ActivityDiaryWriteBinding;

import java.util.ArrayList;

public class DiaryWriteActivity extends AppCompatActivity {

    private ActivityDiaryWriteBinding binding;

    private static final String DIARY_NUMBER = "diaryNumber";
    private static final String DIARY_TITLE = "diaryTitle";
    private static final String DIARY_CONTENT = "diaryContent";
    private SharedPreferences diaryDb;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDiaryWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        diaryDb = getSharedPreferences(DIARY_NUMBER, MODE_PRIVATE);
        editor = diaryDb.edit();
        editor.putInt(DIARY_NUMBER, 1);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.diary_tool_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveIcon:
                int diaryNumber = diaryDb.getInt(DIARY_NUMBER, 100);
                String diaryTitle = binding.diaryTitleEditText.getText().toString();
                String diaryContent = binding.diaryContentEditText.getText().toString();

                diaryNumber++;
                editor.putInt(DIARY_NUMBER, diaryNumber);
                editor.putString(DIARY_TITLE, diaryTitle);
                editor.putString(DIARY_CONTENT, diaryContent);
                editor.apply();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}