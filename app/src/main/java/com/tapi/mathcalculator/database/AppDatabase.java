package com.tapi.mathcalculator.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class AppDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Calculator.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_HISTORY = "history";
    public static final String COLUMN_HISTORY_ID = "hisId";
    public static final String COLUMN_TXT_RESULT = "txtResult";
    public static final String COLUMN_EDT_RESULT = "edtResult";
    public static final String COLUMN_DATE = "hisDate";


    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_HISTORY + " (" +
                    COLUMN_HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TXT_RESULT + " TEXT, " +
                    COLUMN_EDT_RESULT + " TEXT, " +
                    COLUMN_DATE + " TEXT " + ")";


    public AppDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HISTORY);
        db.execSQL(TABLE_CREATE);
    }
}
