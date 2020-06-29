package com.example.lifemedicalinfo;

import androidx.multidex.MultiDexApplication;

import com.google.firebase.FirebaseApp;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LifeMedcialInfoApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);

        Realm.init(this);
        Realm.setDefaultConfiguration(
            new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        );
    }
}
