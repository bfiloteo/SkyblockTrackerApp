package com.example.capstoneproject.Dungeons.CatacombStats;

public class DungeonsCatacombsStats {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils

    private String mProfileName;

    private boolean mVisitedCatacombs;

    private int mEntranceAttempts;

    private int mEntranceCompletions;

    private int mFloorOneAttempts;

    private int mFloorOneCompletions;

    private int mFloorTwoAttempts;

    private int mFloorTwoCompletions;

    private int mFloorThreeAttempts;

    private int mFloorThreeCompletions;

    private int mFloorFourAttempts;

    private int mFloorFourCompletions;

    private int mFloorFiveAttempts;

    private int mFloorFiveCompletions;

    private int mFloorSixAttempts;

    private int mFloorSixCompletions;

    private int mFloorSevenAttempts;

    private int mFloorSevenCompletions;


    // A public method of the class that will hold on the profile name and whether or not the user
    // visited the catacombs. This is for situations where the user has never visited the catacombs.
    public DungeonsCatacombsStats(String profileName, boolean visitedCatacombs) {
        mProfileName = profileName;
        mVisitedCatacombs = visitedCatacombs;
    }
    //A public method of the class that will hold on the profile name, whether or not the user visited
    //the catacombs, and all the attempts and completions for each floor.
    public DungeonsCatacombsStats(String profileName, boolean visitedCatacombs,
                                  int entranceAttempts, int entranceCompletions,
                                  int floorOneAttempts, int floorOneCompletions,
                                  int floorTwoAttempts, int floorTwoCompletions,
                                  int floorThreeAttempts, int floorThreeCompletions,
                                  int floorFourAttempts, int floorFourCompletions,
                                  int floorFiveAttempts, int floorFiveCompletions,
                                  int floorSixAttempts, int floorSixCompletions,
                                  int floorSevenAttempts, int floorSevenCompletions) {
        mProfileName = profileName;
        mVisitedCatacombs = visitedCatacombs;
        mEntranceAttempts = entranceAttempts;
        mEntranceCompletions = entranceCompletions;
        mFloorOneAttempts = floorOneAttempts;
        mFloorOneCompletions = floorOneCompletions;
        mFloorTwoAttempts = floorTwoAttempts;
        mFloorTwoCompletions = floorTwoCompletions;
        mFloorThreeAttempts = floorThreeAttempts;
        mFloorThreeCompletions = floorThreeCompletions;
        mFloorFourAttempts = floorFourAttempts;
        mFloorFourCompletions = floorFourCompletions;
        mFloorFiveAttempts = floorFiveAttempts;
        mFloorFiveCompletions = floorFiveCompletions;
        mFloorSixAttempts = floorSixAttempts;
        mFloorSixCompletions = floorSixCompletions;
        mFloorSevenAttempts = floorSevenAttempts;
        mFloorSevenCompletions = floorSevenCompletions;

    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.

    public String getProfileName() {return mProfileName;}

    public boolean getVisitedCatacombs() {return mVisitedCatacombs;}

    public int getEntranceAttempts() {return mEntranceAttempts;}

    public int getEntranceCompletions() {return mEntranceCompletions;}

    public int getFloorOneAttempts() {return mFloorOneAttempts;}

    public int getFloorOneCompletions() {return mFloorOneCompletions;}

    public int getFloorTwoAttempts() {return mFloorTwoAttempts;}

    public int getFloorTwoCompletions() {return mFloorTwoCompletions;}

    public int getFloorThreeAttempts() {return mFloorThreeAttempts;}

    public int getFloorThreeCompletions() {return mFloorThreeCompletions;}

    public int getFloorFourAttempts() {return mFloorFourAttempts;}

    public int getFloorFourCompletions() {return mFloorFourCompletions;}

    public int getFloorFiveAttempts() {return mFloorFiveAttempts;}

    public int getFloorFiveCompletions() {return mFloorFiveCompletions;}

    public int getFloorSixAttempts() {return mFloorSixAttempts;}

    public int getFloorSixCompletions() {return mFloorSixCompletions;}

    public int getFloorSevenAttempts() {return mFloorSevenAttempts;}

    public int getFloorSevenCompletions() {return mFloorSevenCompletions;}


    }