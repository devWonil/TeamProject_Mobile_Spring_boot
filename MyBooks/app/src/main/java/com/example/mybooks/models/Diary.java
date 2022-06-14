package com.example.mybooks.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary {

    public int diaryId;
    public String diaryTitle;
    public String currentDate;
    public String diaryContent;

    public Diary(int diaryId, String diaryTitle, String currentDate, String diaryContent) {
        this.diaryId = diaryId;
        this.diaryTitle = diaryTitle;
        this.currentDate = currentDate;
        this.diaryContent = diaryContent;
    }

}
