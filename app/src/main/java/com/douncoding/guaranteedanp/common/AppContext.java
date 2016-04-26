package com.douncoding.guaranteedanp.common;

import android.app.Application;

import com.example.dao.DaoSession;

/**
 * Created by YongWoo on 2016-04-26.
 */
public class AppContext extends Application {

    DatabaseManager mDBManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mDBManager = new DatabaseManager(this);

        initDatabases();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initDatabases() {
        DaoSession daoSession = mDBManager.openWritable();
        daoSession.getPlaceDao().deleteAll();
    }
}
