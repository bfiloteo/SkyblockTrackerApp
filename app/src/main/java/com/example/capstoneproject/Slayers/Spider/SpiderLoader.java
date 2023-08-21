package com.example.capstoneproject.Slayers.Spider;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class SpiderLoader extends AsyncTaskLoader<List<Spider>> {

    // Query URL
    private String mUrl;


    // Declaration of loader
    public SpiderLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        // Trigger the loadInBackground() method to execute.
        forceLoad();
    }

    // This is on a background thread
    @Override
    public List<Spider> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of Spider Stats.
        List<Spider> statsData = QueryUtilsForSpider.fetchStatData(mUrl);
        return statsData;
    }
}