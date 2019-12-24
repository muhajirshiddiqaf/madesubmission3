package com.ids.madesubmission3.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ids.madesubmission3.BR;
import com.ids.madesubmission3.R;
import com.ids.madesubmission3.base.BaseFragment;
import com.ids.madesubmission3.databinding.FragmentMovieBinding;
import com.ids.madesubmission3.model.movie.Movie;
import com.ids.madesubmission3.ui.detail.DetailActivity;


public class MovieFragment extends BaseFragment<FragmentMovieBinding,MovieViewModel> implements MovieNavigator {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm.setNavigator(this);
        vm.loadData();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
    public void showDetail(Movie data) {
        Intent i = DetailActivity.newIntent(context);
        i.putExtra(DetailActivity.TAG,data);
        startActivity(i);
    }
}