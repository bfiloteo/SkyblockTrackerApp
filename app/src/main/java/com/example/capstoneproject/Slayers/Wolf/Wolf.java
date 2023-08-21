package com.example.capstoneproject.Slayers.Wolf;

public class Wolf {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils
    private String mSlayerProfileName;

    private int mWolfSlayerLevel;

    private int mCurrentWolfExp;

    private int mNeededWolfExp;

    private int mKilledTierOneWolves;

    private int mKilledTierTwoWolves;

    private int mKilledTierThreeWolves;

    private int mKilledTierFourWolves;

    private int mCoinsSpentOnWolves;

    // A public method of the class that will hold on the profile name, the current slayer level, current exp,
    // needed exp, the amount of times a player has killed the tier per profile, and the amount of coins spent.
    public Wolf(String profileName, int wolfSlayerLevel, int currentWolfExp, int neededWolfExp,
                int killedTierOneWolves, int killedTierTwoWolves, int killedTierThreeWolves, int killedTierFourWolves, int coinsSpentOnWolves ) {
        mSlayerProfileName = profileName;
        mWolfSlayerLevel = wolfSlayerLevel;
        mCurrentWolfExp = currentWolfExp;
        mNeededWolfExp = neededWolfExp;
        mKilledTierOneWolves = killedTierOneWolves;
        mKilledTierTwoWolves = killedTierTwoWolves;
        mKilledTierThreeWolves = killedTierThreeWolves;
        mKilledTierFourWolves = killedTierFourWolves;
        mCoinsSpentOnWolves = coinsSpentOnWolves;
    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.
    public String getProfileName() {return mSlayerProfileName;}

    public int getWolfSlayerLevel() {return mWolfSlayerLevel;}

    public int getCurrentWolfExp() {return mCurrentWolfExp;}

    public int getNeededWolfExp() {return mNeededWolfExp;}

    public int getTierOneWolfKills() {return mKilledTierOneWolves;}

    public int getTierTwoWolfKills() {return mKilledTierTwoWolves;}

    public int getTierThreeWolfKills() {return mKilledTierThreeWolves;}

    public int getTierFourWolfKills() {return mKilledTierFourWolves;}

    public int getCoinsSpentOnWolves() {return mCoinsSpentOnWolves;}

}
