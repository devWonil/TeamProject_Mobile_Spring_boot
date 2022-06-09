package com.example.mybooks;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mybooks.adapter.SliderImageAdapter;
import com.example.mybooks.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ViewGroup viewGroup;
    private FragmentHomeBinding binding;
    private LinearLayout layoutIndicatorsContainer;
    private static HomeFragment fragment;
    private ArrayList<String> imageURL = new ArrayList<>();

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        if (fragment == null) {
            fragment = new HomeFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 샘플이미지 넣어주기
        imageURL.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
        imageURL.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
        imageURL.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
        imageURL.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
        imageURL.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        return viewGroup;
    }

    // SliderImageView 설정
    private void initData() {
        ViewPager2 viewPager2 = viewGroup.findViewById(R.id.slideViewPager);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setAdapter(new SliderImageAdapter(getActivity(), imageURL));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
                Log.d("TAG", "position : " + position);
            }
        });

        setIndicators(imageURL.size());
    }

    //     indicator 띄우기
    private void setIndicators(int count) {
        layoutIndicatorsContainer = viewGroup.findViewById(R.id.indicatorContainer);
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 5, 10, 5);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bg_indicator_active));
            indicators[i].setLayoutParams(params);

            layoutIndicatorsContainer.addView(indicators[i]);
        }
    }

    // 현재 띄우고 있는 indicator 연결
    private void setCurrentIndicator(int position) {
        int count = layoutIndicatorsContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bg_indicator_inactive));
            }
        }
    }

    // recyclerView


}