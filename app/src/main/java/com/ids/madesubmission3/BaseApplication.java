package com.ids.madesubmission3;

import com.ids.madesubmission3.di.component.AppComponent;
import com.ids.madesubmission3.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 14,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */


public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}

//        extends Application {
//    private AppComponent appComponent;
//
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        appComponent= DaggerAppComponent.create();
//    }
//
//    public AppComponent getAppComponent() {
//        return appComponent;
//    }
//}
