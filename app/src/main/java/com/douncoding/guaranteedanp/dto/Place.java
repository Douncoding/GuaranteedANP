package com.douncoding.guaranteedanp.dto;

import android.content.ContentValues;

import java.util.Locale;

public class Place implements Model {
    int id;
    String name;
    String uuid;

    public Place(int id, String name, String uuid) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
    }

    @Override
    public void serialization() {
        ContentValues values = new ContentValues();
    }

    @Override
    public void deserialization() {

    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "ID:%d name:%s uuid:%s",
                id, name, uuid);
    }
}
