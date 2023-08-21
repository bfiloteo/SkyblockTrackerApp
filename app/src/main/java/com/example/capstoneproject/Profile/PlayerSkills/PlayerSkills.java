package com.example.capstoneproject.Profile.PlayerSkills;

public class PlayerSkills {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils

    private String mProfileName;

    private int mTamingLevel;

    private int mCurrentTamingExp;

    private int mNeededTamingExp;

    private int mFarmingLevel;

    private int mCurrentFarmingExp;

    private int mNeededFarmingExp;

    private int mMiningLevel;

    private int mCurrentMiningExp;

    private int mNeededMiningExp;

    private int mCombatLevel;

    private int mCurrentCombatExp;

    private int mNeededCombatExp;

    private int mForagingLevel;

    private int mCurrentForagingExp;

    private int mNeededForagingExp;

    private int mFishingLevel;

    private int mCurrentFishingExp;

    private int mNeededFishingExp;

    private int mEnchantingLevel;

    private int mCurrentEnchantingExp;

    private int mNeededEnchantingExp;

    private int mAlchemyLevel;

    private int mCurrentAlchemyExp;

    private int mNeededAlchemyExp;

    private int mCarpentryLevel;

    private int mCurrentCarpentryExp;

    private int mNeededCarpentryExp;

    private int mRunecraftingLevel;

    private int mCurrentRunecraftingExp;

    private int mNeededRunecraftingExp;

    // A public method of the class that will hold on the profile name, skill level, current skill exp,
    // and needed exp.
    public PlayerSkills(String profileName,
                        int tamingLevel, int currentTamingExp, int neededTamingExp,
                        int farmingLevel, int currentFarmingExp, int neededFarmingExp,
                        int miningLevel, int currentMiningExp, int neededMiningExp,
                        int combatLevel, int currentCombatExp, int neededCombatExp,
                        int foragingLevel, int currentForagingExp, int neededForagingExp,
                        int fishingLevel, int currentFishingExp, int neededFishingExp,
                        int enchantingLevel, int currentEnchantingExp, int neededEnchantingExp,
                        int alchemyLevel, int currentAlchemyExp, int neededAlchemyExp,
                        int carpentryLevel, int currentCarpentryExp, int neededCarpentryExp,
                        int runecraftingLevel, int currentRunecraftingExp, int neededRunecraftingExp) {
        mProfileName = profileName;
        mTamingLevel = tamingLevel;
        mCurrentTamingExp = currentTamingExp;
        mNeededTamingExp = neededTamingExp;
        mFarmingLevel = farmingLevel;
        mCurrentFarmingExp = currentFarmingExp;
        mNeededFarmingExp = neededFarmingExp;
        mMiningLevel = miningLevel;
        mCurrentMiningExp = currentMiningExp;
        mNeededMiningExp = neededMiningExp;
        mCombatLevel = combatLevel;
        mCurrentCombatExp = currentCombatExp;
        mNeededCombatExp = neededCombatExp;
        mForagingLevel = foragingLevel;
        mCurrentForagingExp = currentForagingExp;
        mNeededForagingExp = neededForagingExp;
        mFishingLevel = fishingLevel;
        mCurrentFishingExp = currentFishingExp;
        mNeededFishingExp = neededFishingExp;
        mEnchantingLevel = enchantingLevel;
        mCurrentEnchantingExp = currentEnchantingExp;
        mNeededEnchantingExp = neededEnchantingExp;
        mAlchemyLevel = alchemyLevel;
        mCurrentAlchemyExp = currentAlchemyExp;
        mNeededAlchemyExp = neededAlchemyExp;
        mCarpentryLevel = carpentryLevel;
        mCurrentCarpentryExp = currentCarpentryExp;
        mNeededCarpentryExp = neededCarpentryExp;
        mRunecraftingLevel = runecraftingLevel;
        mCurrentRunecraftingExp = currentRunecraftingExp;
        mNeededRunecraftingExp = neededRunecraftingExp;
    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.

    public String getProfileName() {return mProfileName;}

    public int getTamingLevel() {return mTamingLevel;}

    public int getCurrentTamingExp() {return mCurrentTamingExp;}

    public int getNeededTamingExp() {return mNeededTamingExp;}

    public int getFarmingLevel() {return mFarmingLevel;}

    public int getCurrentFarmingExp() {return mCurrentFarmingExp;}

    public int getNeededFarmingExp() {return mNeededFarmingExp;}

    public int getMiningLevel() {return mMiningLevel;}

    public int getCurrentMiningExp() {return mCurrentMiningExp;}

    public int getNeededMiningExp() {return mNeededMiningExp;}

    public int getCombatLevel() {return mCombatLevel;}

    public int getCurrentCombatExp() {return mCurrentCombatExp;}

    public int getNeededCombatExp() {return mNeededCombatExp;}

    public int getForagingLevel() {return mForagingLevel;}

    public int getCurrentForagingExp() {return mCurrentForagingExp;}

    public int getNeededForagingExp() {return mNeededForagingExp;}

    public int getFishingLevel() {return mFishingLevel;}

    public int getCurrentFishingExp() {return mCurrentFishingExp;}

    public int getNeededFishingExp() {return mNeededFishingExp;}

    public int getEnchantingLevel() {return mEnchantingLevel;}

    public int getCurrentEnchantingExp() {return mCurrentEnchantingExp;}

    public int getNeededEnchantingExp() {return mNeededEnchantingExp;}

    public int getAlchemyLevel() {return mAlchemyLevel;}

    public int getCurrentAlchemyExp() {return mCurrentAlchemyExp;}

    public int getNeededAlchemyExp() {return mNeededAlchemyExp;}

    public int getCarpentryLevel() {return mCarpentryLevel;}

    public int getCurrentCarpentryExp() {return mCurrentCarpentryExp;}

    public int getNeededCarpentryExp() {return mNeededCarpentryExp;}

    public int getRunecraftingLevel() {return mRunecraftingLevel;}

    public int getCurrentRunecraftingExp() {return mCurrentRunecraftingExp;}

    public int getNeededRunecraftingExp() {return mNeededRunecraftingExp;}
}
