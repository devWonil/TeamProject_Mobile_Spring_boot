package com.example.mybooks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybooks.R;

import java.util.ArrayList;

public class SliderImageAdapter extends RecyclerView.Adapter<SliderImageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> slideImageUrl;


    public SliderImageAdapter(Context context, ArrayList<String> slideImageUrl) {
        this.context = context;
        this.slideImageUrl = slideImageUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_slider_image, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindSliderImage(slideImageUrl.get(position));
    }

    @Override
    public int getItemCount() {
        return slideImageUrl.size();
    }

    // 내부클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sliderImageView);
        }

        public void bindSliderImage(String imageURL) {
            Glide.with(context).load(imageURL).centerCrop().into(imageView);
        }
    }

}
