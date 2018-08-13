package com.master.killercode.mcv.Helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseUtil extends Dao {

    public DataBaseUtil(Context context) {
        super(context);
    }

    public void addJob(String tableName, ContentValues data) {
        openDataBase();
        //
        db.beginTransaction();
        //
        try {
            //
            db.insert(tableName, null, data);

            db.setTransactionSuccessful();
        } catch (Exception ignored) {
        } finally {
            db.endTransaction();
        }
        //
        closeDataBase();
    }

    public void deleteJob(String tableName, String field_params) {
        openDataBase();
        //
        try {
            //
            db.delete(tableName, SQLiteHelper.COLLUM + "=?", new String[]{field_params});

        } catch (Exception ignored) {
        }
        //
        closeDataBase();
    }

    public List<String> getList() {

        List<String> list = new ArrayList<>();
        openDataBase();
        //
        try {
            //
            @SuppressLint("Recycle") Cursor cursor = db.query(SQLiteHelper.TABLE_NAME,
                    new String[]{SQLiteHelper.COLLUM}, null, null, null, null, null);

            while (cursor.moveToNext()) {
                list.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLLUM)));
            }

            return list;

        } catch (Exception ignored) {
            Log.w("Error", ignored);
        }
        //
        closeDataBase();

        return null;
    }
}
