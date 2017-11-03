package br.com.rmoreira.app.storages.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public class DaoHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE = "MOVIES";
    private static int VERSION = 1;

    public DaoHelper(Context context) {
        super(context, DaoHelper.DATA_BASE, null, DaoHelper.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MovieContract.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
