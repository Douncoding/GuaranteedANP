package com.douncoding.guaranteedanp.databases;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import com.douncoding.guaranteedanp.common.Constants;

public class PlaceProvider extends ContentProvider {
    public static final String TABLE_NAME = "Place";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_SQL = "CREATE TABLE";


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public interface PlaceColums extends BaseColumns {
        String ID = "id";
        String NAME = "name";
        String UUID = "uuid";
    }

    private class DatabasesHelper extends SQLiteOpenHelper {
        public DatabasesHelper(Context context) {
            super(context, Constants.DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
