package com.example.mybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mybooks.databinding.ActivityDiaryWriteBinding;
import com.example.mybooks.interfaces.OnClickedSaveButton;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DiaryWriteActivity extends AppCompatActivity {

    private ActivityDiaryWriteBinding binding;

    private OnClickedSaveButton onClickedSaveButton;

    public static final String DIARY_DATABASE = "diaryDatabase";
    public static final String DIARY_NUMBER = "diaryNumber";
    public static final String DIARY_TITLE = "diaryTitle";
    public static final String DIARY_CONTENT = "diaryContent";
    public static final String CURRENT_DATE = "currentDate";
    private SharedPreferences diaryDb;
    private SharedPreferences.Editor editor;

    public void setOnClickedSaveButton(OnClickedSaveButton onClickedSaveButton) {
        this.onClickedSaveButton = onClickedSaveButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDiaryWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        diaryDb = getSharedPreferences(DIARY_DATABASE, MODE_PRIVATE);

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
                String currentDate = getCurrentDate();
                String diaryContent = binding.diaryContentEditText.getText().toString();

                diaryNumber++;
                editor.putInt(DIARY_NUMBER, diaryNumber);
                editor.putString(CURRENT_DATE, getCurrentDate());
                editor.putString(DIARY_TITLE, diaryTitle);
                editor.putString(DIARY_CONTENT, diaryContent);
                editor.apply();

                ArrayList<String> list = new ArrayList<>();
                list.add(String.valueOf(diaryNumber));
                list.add(diaryTitle);
                list.add(currentDate);
                list.add(diaryContent);

//                setStringArrayDiaryDb(getApplication(), "diary", list);

                onClickedSaveButton.onClickedSaveButton();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }


}