package com.fjz.gcmnetworkmanagerlib;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by fjz on 06/01/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(getApplicationContext());

    }
}
