package com.ksn.kraiponn.lablistui;

import android.app.Application;

import com.ksn.kraiponn.lablistui.manager.Contextor;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
