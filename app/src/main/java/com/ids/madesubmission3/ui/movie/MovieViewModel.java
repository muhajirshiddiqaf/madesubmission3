package com.ids.madesubmission3.ui.movie;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.ids.madesubmission3.R;
import com.ids.madesubmission3.adapter.movie.MovieAdapter;
import com.ids.madesubmission3.base.BaseObservableViewModel;
import com.ids.madesubmission3.data.repository.movie.MovieRepository;
import com.ids.madesubmission3.model.movie.Movie;
import com.ids.madesubmission3.model.movie.ResponseMovie;

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
public class MovieViewModel extends BaseObservableViewModel<MovieNavigator> implements MovieAdapter.OnItemClickCallback{

    private final MutableLiveData<ResponseMovie> responseMovie = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();
    private MovieRepository restRepository;
    private MovieAdapter adapter;
    public ObservableBoolean isRefresh = new ObservableBoolean();


    @Inject
    public MovieViewModel(@NonNull Application application,MovieRepository restRepository) {
        super(application);
        this.restRepository = restRepository;
        this.adapter = new MovieAdapter(R.layout.item_movie, this);
        this.adapter.setOnItemClickCallback(this);
    }

    public void setMovieInAdapter(ArrayList<Movie> movie) {
        this.adapter.setMovie(movie);
        this.adapter.notifyDataSetChanged();
    }

    public MovieAdapter getAdapter() {
        return adapter;
    }

    public void loadData() {

        getNavigator().showLoading();

        getCompositeDisposable().add(restRepository.modelSingle(getApplication().getApplicationContext().getResources().getString(R.string.movie_language), "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseMovie>() {
                    @Override
                    public void onSuccess(ResponseMovie movie) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        responseMovie.setValue(movie);
                        movies.setValue(responseMovie.getValue().getResults());
                        setMovieInAdapter(getMovie().getValue());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        Log.d("Error get movie", e.getMessage().toString());
                    }
                }));
    }


    public Movie getMovieAt(Integer index) {
        if (responseMovie.getValue() != null &&
                index != null &&
                responseMovie.getValue().getResults().size() > index) {
            return responseMovie.getValue().getResults().get(index);
        }
        return null;
    }

    public MutableLiveData<ArrayList<Movie>> getMovie() {
        return movies;
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
    public void onItemClicked(Movie data) {
        getNavigator().showDetail(data);
    }

    public void onRefresh() {
        isRefresh.set(true);
        loadData();
    }
}