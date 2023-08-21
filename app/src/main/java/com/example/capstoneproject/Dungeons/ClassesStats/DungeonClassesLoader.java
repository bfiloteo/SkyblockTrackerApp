package com.example.capstoneproject.Dungeons.ClassesStats;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import com.example.capstoneproject.Dungeons.ClassesStats.DungeonClasses;
import com.example.capstoneproject.Dungeons.ClassesStats.QueryUtilsForDungeonClasses;

import java.util.List;


public class DungeonClassesLoader extends AsyncTaskLoader<List<DungeonClasses>> {


    // Query URL
    private String mUrl;


    public DungeonClassesLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        // Trigger the loadInBackground() method to execute.
        forceLoad();
    }


     // This is on a background thread.
    @Override
    public List<DungeonClasses> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of class data.
        List<DungeonClasses> classesData = QueryUtilsForDungeonClasses.fetchStatData(mUrl);
        return classesData;
    }
}
