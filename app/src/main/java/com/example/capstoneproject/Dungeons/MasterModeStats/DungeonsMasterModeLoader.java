package com.example.capstoneproject.Dungeons.MasterModeStats;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class DungeonsMasterModeLoader extends AsyncTaskLoader<List<DungeonsMasterModeStats>> {

    // Query URL
    private String mUrl;

    // Declaration of Loader
    public DungeonsMasterModeLoader(Context context, String url) {
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
    public List<DungeonsMasterModeStats> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of Dungeon Master Mode Stats.
        List<DungeonsMasterModeStats> statsData = QueryUtilsForDungeonsMasterMode.fetchStatData(mUrl);
        return statsData;
    }
}