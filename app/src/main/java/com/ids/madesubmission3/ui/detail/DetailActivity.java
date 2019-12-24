package com.ids.madesubmission3.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.ids.madesubmission3.BR;
import com.ids.madesubmission3.R;
import com.ids.madesubmission3.base.BaseActivity;
import com.ids.madesubmission3.databinding.ActivityDetailBinding;
import com.ids.madesubmission3.model.movie.Movie;

public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> implements DetailNavigator {

    public static String TAG = DetailActivity.class.getName();

    public static Intent newIntent(Context context){
        return new Intent(context,DetailActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Movie movie = getIntent().getParcelableExtra(TAG);
        dataBinding.setVariable(BR.movieDetail,movie);

        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public int getBindingVariable() {
        return BR.vmDetail;
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
