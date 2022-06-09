package com.example.mybooks.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mybooks.BestSellerFragment;
import com.example.mybooks.GenreFragment;
import com.example.mybooks.HomeFragment;
import com.example.mybooks.MainActivity;
import com.example.mybooks.NewFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
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
                fragment = BestSellerFragment.newInstance();
                break;
            case 2:
                fragment = new NewFragment(); // 신간
                break;
            case 3:
                fragment = new GenreFragment(); // 장르별
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }
}
