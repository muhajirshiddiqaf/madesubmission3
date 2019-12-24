package com.ids.madesubmission3.data.repository.movie;

import com.ids.madesubmission3.data.rest.RestService;
import com.ids.madesubmission3.model.movie.ResponseMovie;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.ids.madesubmission3.util.AppConstants.API_KEY;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 14,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public class MovieRepository {

    private RestService restService;

    @Inject
    public MovieRepository(RestService restService) {
        this.restService = restService;
    }


    public Single<ResponseMovie> modelSingle(String language, String page) {
        return restService.getMovie(API_KEY, language, page);
    }
}
