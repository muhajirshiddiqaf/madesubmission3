package com.ids.madesubmission3.data.rest;

import com.ids.madesubmission3.model.movie.ResponseMovie;
import com.ids.madesubmission3.model.tvshow.ResponseTvShow;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 14,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public interface RestService {

    @GET("discover/movie")
    Single<ResponseMovie> getMovie(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page);

    @GET("discover/tv")
    Single<ResponseTvShow> getTv(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page);

}
