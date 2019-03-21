package com.tapi.mathcalculator;

import android.app.Application;
import android.content.res.Configuration;

import com.tapi.mathcalculator.helpler.PreferenceHelper;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceHelper.create(this);
    }



}
