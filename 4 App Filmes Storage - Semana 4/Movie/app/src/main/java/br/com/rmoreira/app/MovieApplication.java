package br.com.rmoreira.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public final class MovieApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

}
