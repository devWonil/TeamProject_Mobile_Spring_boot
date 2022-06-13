package com.example.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mybooks.adapter.PagerAdapter;
import com.example.mybooks.databinding.ActivityMainBinding;
import com.example.mybooks.interfaces.OnClickedSaveButton;
import com.example.mybooks.utils.FragmentType;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private PagerAdapter pagerAdapter;
    public static final int TAB_COUNT = 4;
    private String tabTitle[] = {"추천", "베스트", "신간", "장르별"};
    Fragment fragment;


    private void initData() {
        for (String name : tabTitle) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(name));
        }
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), TAB_COUNT);
    }

    private void addEventListener() {
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int currentPage = tab.getPosition();
                binding.mainViewPager.setCurrentItem(currentPage);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        binding.mainViewPager.setAdapter(pagerAdapter);
        binding.mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

    }

    private void replaceFragment(FragmentType type) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.HOME) {
            transaction.remove(fragment);
            setContentView(binding.getRoot());
        } else if (type == FragmentType.DIARY) {
            fragment = DiaryHomeFragment.newInstance();
            transaction.replace(binding.fragmentContainer.getId(), fragment);
        } else if (type == FragmentType.LIKE) {
            fragment = new LikeFragment();
            transaction.replace(binding.fragmentContainer.getId(), fragment);
        }
        transaction.commit();
    }

    private void addBottomNaviListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homePage:
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.diaryPage:
                    replaceFragment(FragmentType.DIARY);
                    break;
                case R.id.likePage:
                    replaceFragment(FragmentType.LIKE);
                    break;
            }
            return true;
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        binding.tabLayout.setVisibility(View.GONE);
        initData();
        addEventListener();
        if (fragment != null) {
            replaceFragment(FragmentType.HOME);
        }
        addBottomNaviListener();
        Toolbar toolbar = findViewById(R.id.topAppbar);
        setSupportActionBar(toolbar);
    }

    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.searchIcon) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }
        return true;
    }

}