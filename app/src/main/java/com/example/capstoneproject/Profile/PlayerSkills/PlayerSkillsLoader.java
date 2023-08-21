package com.example.capstoneproject.Profile.PlayerSkills;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import com.example.capstoneproject.Dungeons.ClassesStats.DungeonClasses;
import com.example.capstoneproject.Dungeons.ClassesStats.QueryUtilsForDungeonClasses;

import java.util.List;


public class PlayerSkillsLoader extends AsyncTaskLoader<List<PlayerSkills>> {


    // Query URL
    private String mUrl;

    // Declaration of Loader
    public PlayerSkillsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        // Trigger the loadInBackground() method to execute.
        forceLoad();
    }

    //This is on a background thread.

    @Override
    public List<PlayerSkills> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of Player Skills.
        List<PlayerSkills> skillsData = QueryUtilsForPlayerSkills.fetchStatData(mUrl);
        return skillsData;
    }
}