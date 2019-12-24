package com.ids.madesubmission3.di.modules;

import com.ids.madesubmission3.ui.detail.DetailActivity;
import com.ids.madesubmission3.ui.detailtv.DetailTvActivity;
import com.ids.madesubmission3.ui.main.MainActivity;
import com.ids.madesubmission3.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {})
    abstract DetailActivity bindDetailActivity();

    @ContributesAndroidInjector(modules = {})
    abstract DetailTvActivity bindDetailTvActivity();

}
