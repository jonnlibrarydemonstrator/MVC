package com.master.killercode.mcv;

import android.content.ContentValues;
import android.content.Context;
import com.master.killercode.mcv.Helper.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class mvcController {
    private mvcModel model;
    private List<String> jobList;

    mvcController(Context context) {
        jobList = new ArrayList<>();
        model = new mvcModel(context);
    }

    public void addJob(final String title) {
        final ContentValues data = new ContentValues();
        data.put(SQLiteHelper.COLLUM, title);
        model.addJob(data);
    }

    public void deleteJob(final String title) {
        model.deleteJob(title);
    }

//    public void deleteJob(final long id) {
//        model.deleteJob("id='" + id + "'");
//    }
//
//    public void deleteAllJob() {
//        model.deleteJob(null);
//    }

    public List<String> getJobsList() {
        jobList.clear();
        jobList = model.loadAllJobs();
        return jobList;
    }
}
