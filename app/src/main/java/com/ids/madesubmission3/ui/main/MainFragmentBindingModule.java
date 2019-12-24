package com.ids.madesubmission3.ui.main;

import com.ids.madesubmission3.ui.movie.MovieFragment;
import com.ids.madesubmission3.ui.tvshow.TvShowFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract MovieFragment provideMovieFragment();

    @ContributesAndroidInjector
    abstract TvShowFragment provideTvShowFragment();

}
