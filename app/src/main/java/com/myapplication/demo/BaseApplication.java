package com.myapplication.demo;

import android.app.Application;

public class BaseApplication extends Application {

    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static Application getInstance() {
        return instance;
    }
}
