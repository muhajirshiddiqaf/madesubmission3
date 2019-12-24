package com.ids.madesubmission3.ui.detailtv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.ids.madesubmission3.BR;
import com.ids.madesubmission3.R;
import com.ids.madesubmission3.base.BaseActivity;
import com.ids.madesubmission3.databinding.ActivityDetailTvBinding;
import com.ids.madesubmission3.model.tvshow.TvShow;
import com.ids.madesubmission3.ui.detail.DetailNavigator;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 23,December,2019.
 * Email : infinitydsolution@gmail.com
 * Company : Infinity Digital Solution
 */
public class DetailTvActivity extends BaseActivity<ActivityDetailTvBinding, DetailTvViewModel> implements DetailNavigator {

    public static String TAG = DetailTvActivity.class.getName();

    public static Intent newIntent(Context context){
        return new Intent(context, DetailTvActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TvShow tvShow = getIntent().getParcelableExtra(TAG);
        dataBinding.setVariable(BR.tvDetail,tvShow);

        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail_tv;
    }

    @Override
    public int getBindingVariable() {
        return BR.vmTvDetail;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}

