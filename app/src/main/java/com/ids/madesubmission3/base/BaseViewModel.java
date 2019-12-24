package com.ids.madesubmission3.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends AndroidViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    private CompositeDisposable disposable;

    private WeakReference<N> mNavigator;


    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.disposable = new CompositeDisposable();
    }


    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return disposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
}
