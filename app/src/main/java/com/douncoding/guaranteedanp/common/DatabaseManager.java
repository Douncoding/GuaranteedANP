package com.douncoding.guaranteedanp.common;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.dao.DaoMaster;
import com.example.dao.DaoSession;
import com.example.dao.Place;
import com.example.dao.PlaceDao;

import java.util.List;

import de.greenrobot.dao.DaoLog;

public class DatabaseManager {
    public static final String TAG = DatabaseManager.class.getSimpleName();

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        mHelper = new DaoMaster.DevOpenHelper(context, Constants.DATABASE_NAME, null);
    }

    public DaoSession openReadable() throws SQLiteException {
        database = mHelper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

    public DaoSession openWritable() throws SQLiteException {
        database = mHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();

        return daoSession;
    }

    public void insertPlace() {

    }

    public void printAllPlace() {
        PlaceDao placeDao = openReadable().getPlaceDao();

        Cursor cursor = database.query(placeDao.getTablename()
                , placeDao.getAllColumns()
                , null
                , null
                , null
                , null
                , null);

        DaoLog.d(DatabaseUtils.dumpCursorToString(cursor));
    }
}
