package com.example.mybooks.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mybooks.BestSellerFragment;
import com.example.mybooks.GenreFragment;
import com.example.mybooks.HomeFragment;
import com.example.mybooks.MainActivity;
import com.example.mybooks.NewBookFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new BestSellerFragment();
                break;
            case 2:
                fragment = new NewBookFragment();
                break;
            case 3:
                fragment = new GenreFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }
}
