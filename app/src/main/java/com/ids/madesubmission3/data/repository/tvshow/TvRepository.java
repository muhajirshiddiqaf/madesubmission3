package com.ids.madesubmission3.data.repository.tvshow;

import com.ids.madesubmission3.data.rest.RestService;
import com.ids.madesubmission3.model.tvshow.ResponseTvShow;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.ids.madesubmission3.util.AppConstants.API_KEY;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 14,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public class TvRepository {

    private RestService restService;

    @Inject
    public TvRepository(RestService restService) {
        this.restService = restService;
    }


    public Single<ResponseTvShow> modelSingle(String language, String page) {
        return restService.getTv(API_KEY, language, page);
    }
}
