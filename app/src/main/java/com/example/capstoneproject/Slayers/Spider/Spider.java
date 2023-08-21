package com.example.capstoneproject.Slayers.Spider;

public class Spider {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils
    private String mProfileName;

    private int mSpiderSlayerLevel;

    private int mCurrentSpiderExp;

    private int mNeededSpiderExp;

    private int mKilledTierOneSpiders;

    private int mKilledTierTwoSpiders;

    private int mKilledTierThreeSpiders;

    private int mKilledTierFourSpiders;

    private int mCoinsSpentOnSpiders;

    // A public method of the class that will hold on the profile name, the current slayer level, current exp,
    // needed exp, the amount of times a player has killed the tier per profile, and the amount of coins spent.

    public Spider(String profileName, int spiderSlayerLevel, int currentSpiderExp, int neededSpiderExp,
                  int killedTierOneSpiders, int killedTierTwoSpiders, int killedTierThreeSpiders, int killedTierFourSpiders,
                  int coinsSpentOnSpiders) {
        mProfileName = profileName;
        mSpiderSlayerLevel = spiderSlayerLevel;
        mCurrentSpiderExp = currentSpiderExp;
        mNeededSpiderExp = neededSpiderExp;
        mKilledTierOneSpiders = killedTierOneSpiders;
        mKilledTierTwoSpiders = killedTierTwoSpiders;
        mKilledTierThreeSpiders = killedTierThreeSpiders;
        mKilledTierFourSpiders = killedTierFourSpiders;
        mCoinsSpentOnSpiders = coinsSpentOnSpiders;
    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.
    public String getProfileName() {return mProfileName;}
    public int getSpiderSlayerLevel() {return mSpiderSlayerLevel;}
    public int getCurrentSpiderExp() {return mCurrentSpiderExp;}
    public int getNeededSpiderExp() {return mNeededSpiderExp;}
    public int getTierOneSpiderKills() {return mKilledTierOneSpiders;}
    public int getTierTwoSpiderKills() {return mKilledTierTwoSpiders;}
    public int getTierThreeSpiderKills() {return mKilledTierThreeSpiders;}
    public int getTierFourSpiderKills() {return mKilledTierFourSpiders;}
    public int getCoinsSpentSpiders() {return mCoinsSpentOnSpiders;}
}
