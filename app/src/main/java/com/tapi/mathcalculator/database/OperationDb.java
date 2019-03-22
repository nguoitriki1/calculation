package com.tapi.mathcalculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import com.tapi.mathcalculator.model.HistoryModel;

import java.util.ArrayList;
import java.util.List;

public class OperationDb {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    private SQLiteOpenHelper dbhandler;
    private SQLiteDatabase database;

    private static final String[] allColumns = {
            AppDatabase.COLUMN_HISTORY_ID,
            AppDatabase.COLUMN_TXT_RESULT,
            AppDatabase.COLUMN_EDT_RESULT,
            AppDatabase.COLUMN_DATE
    };

    public OperationDb(Context context){
        dbhandler = new AppDatabase(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public HistoryModel addHistory(HistoryModel historyModel){
        ContentValues values  = new ContentValues();
//        values.put(  AppDatabase.COLUMN_HISTORY_ID,historyModel.getIdHis());
        values.put( AppDatabase.COLUMN_TXT_RESULT,historyModel.getTxtResult());
        values.put( AppDatabase.COLUMN_EDT_RESULT,historyModel.getEdtResult());
        values.put( AppDatabase.COLUMN_DATE,historyModel.getHisDate());
        long insertid = database.insert(AppDatabase.TABLE_HISTORY,null,values);
//        historyModel.setIdHis(insertid);
        return historyModel;

    }

    // Getting single HistoryModel
    public HistoryModel getHistoryModel(long id) {

        Cursor cursor = database.query(AppDatabase.TABLE_HISTORY,allColumns,AppDatabase.COLUMN_HISTORY_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        HistoryModel e = null;
        if (cursor != null) {
            e = new HistoryModel(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        }
        // return HistoryModel
        return e;
    }

    public List<HistoryModel> getAllHistoryModel() {
        String dateHeader = null;
        Cursor cursor = database.query(AppDatabase.TABLE_HISTORY,allColumns,null,null,null, null, null);

        List<HistoryModel> modelList = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                HistoryModel historyModel = new HistoryModel();
                historyModel.setIdHis(cursor.getLong(cursor.getColumnIndex(AppDatabase.COLUMN_HISTORY_ID)));
                historyModel.setTxtResult(cursor.getString(cursor.getColumnIndex(AppDatabase.COLUMN_TXT_RESULT)));
                historyModel.setEdtResult(cursor.getString(cursor.getColumnIndex(AppDatabase.COLUMN_EDT_RESULT)));
                historyModel.setHisDate(cursor.getString(cursor.getColumnIndex(AppDatabase.COLUMN_DATE)));
                if (TextUtils.isEmpty(dateHeader)){
                    HistoryModel historyModelHeader = new HistoryModel();
                    historyModelHeader.setHeader(true);
                    historyModelHeader.setHisDate(historyModel.getHisDate());
                    dateHeader = historyModel.getHisDate();
                    modelList.add(historyModelHeader);
                }else {
                    if (dateHeader != null) {
                        if (!historyModel.getHisDate().contains(dateHeader)){
                            HistoryModel historyModelHeader = new HistoryModel();
                            historyModelHeader.setHeader(true);
                            historyModelHeader.setHisDate(historyModel.getHisDate());
                            dateHeader = historyModel.getHisDate();
                            modelList.add(historyModelHeader);
                        }
                    }
                }
                modelList.add(historyModel);
            }
            dateHeader = null;
        }
        // return All Employees
        return modelList;
    }




    // Updating HistoryModel
    public int updateHistoryModel(HistoryModel historyModel) {

        ContentValues values = new ContentValues();
        values.put(AppDatabase.COLUMN_TXT_RESULT, historyModel.getTxtResult());
        values.put(AppDatabase.COLUMN_EDT_RESULT, historyModel.getEdtResult());
        values.put(AppDatabase.COLUMN_DATE, historyModel.getHisDate());

        // updating row
        return database.update(AppDatabase.TABLE_HISTORY, values,
                AppDatabase.COLUMN_HISTORY_ID + "=?",new String[] { String.valueOf(historyModel.getIdHis())});
    }

    // Deleting HistoryModel
    public void removeHistoryModel(HistoryModel historyModel) {

        database.delete(AppDatabase.TABLE_HISTORY, AppDatabase.COLUMN_HISTORY_ID + "=" + historyModel.getIdHis(), null);
    }
    public void removeAllHistory(){
        database.execSQL("delete from "+ AppDatabase.TABLE_HISTORY);
    }
}
