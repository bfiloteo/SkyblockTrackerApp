package com.example.capstoneproject.Dungeons.MasterModeStats;

public class DungeonsMasterModeStats {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils

    private String mMasterModeProfileName;

    private boolean mVisitedMasterMode;

    private int mMasterModeFloorOneCompletions;

    private int mMasterModeFloorTwoCompletions;

    private int mMasterModeFloorThreeCompletions;

    private int mMasterModeFloorFourCompletions;

    private int mMasterModeFloorFiveCompletions;

    private int mMasterModeFloorSixCompletions;

    // A public method of the class that will hold on the profile name and whether or not the user
    // visited the catacombs. This is for situations where the user has never visited the catacombs.
    // and has no MasterMode stats

    public DungeonsMasterModeStats(String MasterModeProfileName, boolean visitedMasterMode) {
        mMasterModeProfileName = MasterModeProfileName;
        mVisitedMasterMode = visitedMasterMode;
    }

    // A public method of the class that will hold on the profile name, whether or not the user visited
    // the catacombs, and all stats for all 6 MasterMode floors.
    public DungeonsMasterModeStats(String profileName, boolean visitedMasterMode,
                                   int floorOneCompletions,
                                   int floorTwoCompletions,
                                   int floorThreeCompletions,
                                   int floorFourCompletions,
                                   int floorFiveCompletions,
                                   int floorSixCompletions) {
        mMasterModeProfileName = profileName;
        mVisitedMasterMode = visitedMasterMode;
        mMasterModeFloorOneCompletions = floorOneCompletions;
        mMasterModeFloorTwoCompletions = floorTwoCompletions;
        mMasterModeFloorThreeCompletions = floorThreeCompletions;
        mMasterModeFloorFourCompletions = floorFourCompletions;
        mMasterModeFloorFiveCompletions = floorFiveCompletions;
        mMasterModeFloorSixCompletions = floorSixCompletions;

    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.
    public String getProfileName() {
        return mMasterModeProfileName;
    }

    public int getMasterModeFloorOneCompletions() {return mMasterModeFloorOneCompletions;}

    public int getMasterModeFloorTwoCompletions() {return mMasterModeFloorTwoCompletions;}

    public int getMasterModeFloorThreeCompletions() {return mMasterModeFloorThreeCompletions;}

    public int getMasterModeFloorFourCompletions() {return mMasterModeFloorFourCompletions;}

    public int getMasterModeFloorFiveCompletions() {return mMasterModeFloorFiveCompletions;}

    public int getMasterModeFloorSixCompletions() {return mMasterModeFloorSixCompletions;}
}
