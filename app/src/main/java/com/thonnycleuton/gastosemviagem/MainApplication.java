package com.thonnycleuton.gastosemviagem;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by thonnycleuton on 04/10/16.
 */
public class MainApplication extends Application {

    private static MainApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext())
                .name("mainApplication.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public static MainApplication getInstance() {
        return context;
    }

}
