package com.ids.madesubmission3.di.modules;

import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ids.madesubmission3.custom.EmptyRecyclerView;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 15,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public class CustomViewBindings {

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(EmptyRecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }


    @BindingAdapter("android:rating")
    public static void bindRating(RatingBar view, double rating) {
        if (view.getRating() != rating) {
            view.setRating((float)(rating/2));
        }
    }



}
