package com.nenton.gamesofthrones.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.stetho.Stetho;
import com.nenton.gamesofthrones.data.storage.DaoMaster;
import com.nenton.gamesofthrones.data.storage.DaoSession;

import org.greenrobot.greendao.database.Database;


public class GOTAplication extends Application {

    private static Context sContext;
    private static SharedPreferences sSharedPreferences;
    private static DaoSession sDaoSession;

    /**
     * Create shared preferences
     */
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"GOT");
        Database database = helper.getWritableDb();
        sDaoSession = new DaoMaster(database).newSession();

        Stetho.initializeWithDefaults(this);

    }

    public static SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

    public static Context getContext() {
        return sContext;
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
