package com.example.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mybooks.adapter.TabPagerAdapter;
import com.example.mybooks.databinding.ActivityMainBinding;
import com.example.mybooks.models.Book;
import com.example.mybooks.utils.FragmentType;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Book> likeBookList = new ArrayList<>();

    ActivityMainBinding binding;
    private TabPagerAdapter pagerAdapter;
    public static final int TAB_COUNT = 4;
    private String tabTitle[] = {"추천", "베스트", "신간", "장르별"};
    Fragment fragment;
    public static Stack<Fragment> fragmentStack = new Stack<>();
    private long backPressedTime = 0;
    Toast toast;


    private void initData() {
        for (String name : tabTitle) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(name));
        }
        pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), TAB_COUNT);
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
            fragmentStack.push(fragment);
        } else if (type == FragmentType.LIKE) {
            fragment = LikeFragment.newInstance();
            transaction.replace(binding.fragmentContainer.getId(), fragment);
            fragmentStack.push(fragment);
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

    @Override
    public void onBackPressed() {
        if (!fragmentStack.isEmpty()) {
            replaceFragment(FragmentType.HOME);
            fragmentStack.clear();
        } else {
            if (System.currentTimeMillis() > backPressedTime + 2000) {
                backPressedTime = System.currentTimeMillis();
                toast = Toast.makeText(this, "버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT);
                toast.show();
                return;
            } else if (System.currentTimeMillis() <= backPressedTime + 2000) {
                finish();
            }
        }
    }
}