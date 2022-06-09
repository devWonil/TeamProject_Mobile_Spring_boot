package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        moveMain(1); // 1초 후 mainActivity로 넘어감
    }
    
    private void moveMain(int sec){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // new Intent (현재 context, 이동할 activity)
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                
                startActivity(intent); // intent의 액티비티로 이동
                
                finish(); // 현재 activity 종료
            }
        }, 1000 * sec); // sec초 정도 딜레이를 준 후 시작
    }
}