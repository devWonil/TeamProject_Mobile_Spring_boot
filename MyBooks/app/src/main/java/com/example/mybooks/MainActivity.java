package com.example.mybooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    static final int TAB_COUNT = 4;
    private String tabTitle[] = {"추천", "베스트", "신간", "장르별"};


    private void initData() {
        viewPager = findViewById(R.id.mainViewPager);
        tabLayout = findViewById(R.id.tabLayout);
        for (String name : tabTitle) {
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), TAB_COUNT);
    }

    private void addEventListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int currentPage = tab.getPosition();
                viewPager.setCurrentItem(currentPage);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }
}