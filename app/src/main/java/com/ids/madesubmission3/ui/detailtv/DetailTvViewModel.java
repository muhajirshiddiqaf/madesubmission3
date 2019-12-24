package com.ids.madesubmission3.ui.detailtv;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ids.madesubmission3.base.BaseViewModel;
import com.ids.madesubmission3.data.repository.movie.MovieRepository;
import com.ids.madesubmission3.ui.detail.DetailNavigator;

import javax.inject.Inject;

import static com.ids.madesubmission3.util.AppConstants.BASE_IMAGE;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 14,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */

public class DetailTvViewModel extends BaseViewModel<DetailNavigator> {

    private MovieRepository restRepository;


    @Inject
    public DetailTvViewModel(@NonNull Application application, MovieRepository restRepository) {
        super(application);
        this.restRepository = restRepository;
    }

    public String getPoster(String imageUrl){
        return BASE_IMAGE + imageUrl;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (getCompositeDisposable() != null) {
            getCompositeDisposable().clear();

        }
    }
}
