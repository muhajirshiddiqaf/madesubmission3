package com.ids.madesubmission3.ui.tvshow;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.ids.madesubmission3.R;
import com.ids.madesubmission3.adapter.tvshow.TvShowAdapter;
import com.ids.madesubmission3.base.BaseViewModel;
import com.ids.madesubmission3.data.repository.tvshow.TvRepository;
import com.ids.madesubmission3.model.tvshow.ResponseTvShow;
import com.ids.madesubmission3.model.tvshow.TvShow;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.ids.madesubmission3.util.AppConstants.BASE_IMAGE;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 15,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public class TvShowViewModel extends BaseViewModel<TvShowNavigator> implements TvShowAdapter.OnItemClickCallback{

    private final MutableLiveData<ResponseTvShow> responseTvShow = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TvShow>> tvshows = new MutableLiveData<>();
    private TvRepository restRepository;
    private TvShowAdapter adapter;
    public ObservableBoolean isRefresh = new ObservableBoolean();

    @Inject
    public TvShowViewModel(@NonNull Application application,TvRepository restRepository) {
        super(application);
        this.restRepository = restRepository;
        this.adapter = new TvShowAdapter(R.layout.item_tv_show, this);
    }

    public void setTvShowInAdapter(ArrayList<TvShow> tvshow) {
        this.adapter.setTvShow(tvshow);
        this.adapter.notifyDataSetChanged();
        this.adapter.setOnItemClickCallback(this);
    }

    public TvShowAdapter getAdapter() {
        return adapter;
    }

    public void loadData() {

        getNavigator().showLoading();

        getCompositeDisposable().add(restRepository.modelSingle(getApplication().getApplicationContext().getResources().getString(R.string.movie_language), "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseTvShow>() {
                    @Override
                    public void onSuccess(ResponseTvShow tvshow) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        responseTvShow.setValue(tvshow);
                        tvshows.setValue(responseTvShow.getValue().getTvShows());
                        setTvShowInAdapter(getTvShow().getValue());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        Log.d("Error get tvshow", e.getMessage().toString());
                    }
                }));
    }


    public TvShow getTvShowAt(Integer index) {
        if (responseTvShow.getValue() != null &&
                index != null &&
                responseTvShow.getValue().getTvShows().size() > index) {
            return responseTvShow.getValue().getTvShows().get(index);
        }
        return null;
    }

    public MutableLiveData<ArrayList<TvShow>> getTvShow() {
        return tvshows;
    }

    public String getPoster(String imageUrl){
        return BASE_IMAGE + imageUrl;
    }

    public String getOverview(String overview){
        try {
            return overview.substring(0,100) +" [More] ";
        }catch (Exception e){
            return " [More] ";
        }
    }

    @Override
    public void onItemClicked(TvShow data) {
        getNavigator().showDetail(data);
    }

    public void onRefresh() {
        isRefresh.set(true);
        loadData();
    }
}