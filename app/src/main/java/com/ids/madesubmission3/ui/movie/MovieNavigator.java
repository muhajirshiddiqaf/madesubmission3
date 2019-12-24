package com.ids.madesubmission3.ui.movie;

import com.ids.madesubmission3.base.BaseNavigator;
import com.ids.madesubmission3.model.movie.Movie;

public interface MovieNavigator extends BaseNavigator {
    void showDetail(Movie data);
}
