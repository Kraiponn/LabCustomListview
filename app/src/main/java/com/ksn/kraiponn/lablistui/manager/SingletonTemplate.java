package com.ksn.kraiponn.lablistui.manager;

import android.content.Context;

public class SingletonTemplate {
    private static SingletonTemplate sInstance;

    public static SingletonTemplate getInstance() {
        if (sInstance == null) {
            sInstance = new SingletonTemplate();
        }

        return sInstance;
    }

    private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }

    public Context getContext() {
        return mContext;
    }

}
