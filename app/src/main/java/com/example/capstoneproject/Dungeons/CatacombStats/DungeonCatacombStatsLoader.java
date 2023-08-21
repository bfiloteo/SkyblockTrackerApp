package com.example.capstoneproject.Dungeons.CatacombStats;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;


public class DungeonCatacombStatsLoader extends AsyncTaskLoader<List<DungeonsCatacombsStats>> {


    // Query URL
    private String mUrl;


    public DungeonCatacombStatsLoader(Context context, String url) {
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
    public List<DungeonsCatacombsStats> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Performs the network request, parses the response, and extracts a list of Catacomb stats per profile.
        List<DungeonsCatacombsStats> statsData = QueryUtilsForDungeonCatacombs.fetchStatData(mUrl);
        return statsData;
    }
}
