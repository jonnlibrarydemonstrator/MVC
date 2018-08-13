package com.master.killercode.mcv;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.master.killercode.mcv.Helper.DataBaseUtil;
import com.master.killercode.mcv.Helper.SQLiteHelper;

import java.util.List;

final class mvcModel {

    private DataBaseUtil dbUtil;

    mvcModel(Context context) {
        dbUtil = new DataBaseUtil(context);
    }

    public void addJob(ContentValues data) {
        dbUtil.addJob(SQLiteHelper.TABLE_NAME, data);
    }

    public void deleteJob(final String field_params) {
       dbUtil.deleteJob(SQLiteHelper.TABLE_NAME, field_params);
    }

    public List<String> loadAllJobs() {
        return dbUtil.getList();
    }
}