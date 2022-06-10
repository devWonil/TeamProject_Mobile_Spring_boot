package com.example.mybooks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybooks.adapter.DiaryListAdapter;
import com.example.mybooks.databinding.FragmentDiaryHomeBinding;
import com.example.mybooks.interfaces.OnClickedSaveButton;
import com.example.mybooks.repository.models.Diary;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DiaryHomeFragment extends Fragment implements OnClickedSaveButton {

    private FragmentDiaryHomeBinding binding;
    private static DiaryHomeFragment diaryFragment;
    private DiaryListAdapter diaryListAdapter;

//    SharedPreferences diaryDb = getContext().getSharedPreferences(DiaryWriteActivity.DIARY_DATABASE, Context.MODE_PRIVATE);

    private ArrayList<Diary> diaryList = new ArrayList<>();

    public DiaryHomeFragment() {
        // Required empty public constructor
    }

    public static DiaryHomeFragment newInstance() {
        DiaryHomeFragment fragment = new DiaryHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_home, container, false);
    }

    public void setDiaryRecyclerView() {
        diaryListAdapter = new DiaryListAdapter();
//        diaryListAdapter.initDiaryList();
    }

//    private void getDiaryDb() {
//        int diaryNumber = diaryDb.getInt(DiaryWriteActivity.DIARY_NUMBER, -1);
//        String diaryTitle = diaryDb.getString(DiaryWriteActivity.DIARY_TITLE, "제목없음");
//        String currentDate = diaryDb.getString(DiaryWriteActivity.CURRENT_DATE, "날짜없음");
//        String diaryContent = diaryDb.getString(DiaryWriteActivity.DIARY_CONTENT, "내용없음");
//
//        Diary diary = new Diary(diaryNumber, diaryTitle, currentDate, diaryContent);
//
//
//    }

    private ArrayList<String> getStringArrayDiaryDb(Context context, String key) {
        SharedPreferences diaryDb = PreferenceManager.getDefaultSharedPreferences(context);
        String json = diaryDb.getString(key, null);
        ArrayList<String> diary = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                String data = jsonArray.optString(i);
                diary.add(data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return diary;
    }

    @Override
    public void onClickedSaveButton() {
        getStringArrayDiaryDb(getContext(), "diary");
    }
}