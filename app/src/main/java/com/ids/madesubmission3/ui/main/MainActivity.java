package com.ids.madesubmission3.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.ids.madesubmission3.BR;
import com.ids.madesubmission3.R;
import com.ids.madesubmission3.adapter.menu.MenuAdapter;
import com.ids.madesubmission3.base.BaseActivity;
import com.ids.madesubmission3.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> implements MainNavigator {

    private MenuAdapter menuAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public int getBindingVariable() {
        return BR.vmMain;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        initData();
        initViews();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void showMessage(String msg) {

    }

    public void initData() {
        menuAdapter = new MenuAdapter(this, getSupportFragmentManager());
    }

    public void initViews() {
        dataBinding.viewPager.setAdapter(menuAdapter);
        dataBinding.tabs.setupWithViewPager(dataBinding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
