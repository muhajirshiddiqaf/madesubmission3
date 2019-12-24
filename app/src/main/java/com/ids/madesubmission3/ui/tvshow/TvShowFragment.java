package com.ids.madesubmission3.ui.tvshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ids.madesubmission3.BR;
import com.ids.madesubmission3.R;
import com.ids.madesubmission3.base.BaseFragment;
import com.ids.madesubmission3.databinding.FragmentMovieBinding;
import com.ids.madesubmission3.model.tvshow.TvShow;
import com.ids.madesubmission3.ui.detailtv.DetailTvActivity;

public class TvShowFragment extends BaseFragment<FragmentMovieBinding,TvShowViewModel> implements TvShowNavigator{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm.setNavigator(this);
        vm.loadData();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_tv_show;
    }

    @Override
    public int getBindingVariable() {
        return BR.vmTv;
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
    public void showDetail(TvShow data) {
        Intent i = DetailTvActivity.newIntent(context);
        i.putExtra(DetailTvActivity.TAG,data);
        startActivity(i);
    }
}
