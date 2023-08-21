package com.example.capstoneproject.Profile.PlayerStats;

import android.content.Context;


import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class PlayerStatsLoader extends AsyncTaskLoader<List<PlayerStats>> {

    // Query URL
    private String mUrl;

    // Declaration of Loader
    public PlayerStatsLoader(Context context, String url) {
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
    public List<PlayerStats> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of player stats.
        List<PlayerStats> statsData = QueryUtilsForPlayerStats.fetchStatData(mUrl);
        return statsData;
    }
}