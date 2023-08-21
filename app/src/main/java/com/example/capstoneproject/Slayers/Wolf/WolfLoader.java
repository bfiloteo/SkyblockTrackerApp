package com.example.capstoneproject.Slayers.Wolf;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class WolfLoader extends AsyncTaskLoader<List<Wolf>> {

    // Query URL
    private String mUrl;


    // Loader
    public WolfLoader(Context context, String url) {
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
    public List<Wolf> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of Wolf Stats.
        List<Wolf> statsData = QueryUtilsForWolf.fetchStatData(mUrl);
        return statsData;
    }
}
