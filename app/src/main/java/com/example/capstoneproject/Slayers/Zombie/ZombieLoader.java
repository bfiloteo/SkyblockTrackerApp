package com.example.capstoneproject.Slayers.Zombie;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;


import java.util.List;

public class ZombieLoader extends AsyncTaskLoader<List<Zombie>> {

    /**
     * Query URL
     */
    private String mUrl;


    public ZombieLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        // Trigger the loadInBackground() method to execute.
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Zombie> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of Spider Stats.
        List<Zombie> statsData = QueryUtilsForZombie.fetchStatData(mUrl);
        return statsData;
    }
}