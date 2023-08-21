package com.example.capstoneproject.Slayers.Zombie;

public class Zombie {

    private String mSlayerProfileName;

    private int mZombieSlayerLevel;

    private int mCurrentZombieExp;

    private int mNeededZombieExp;

    private int mKilledTierOneZombies;

    private int mKilledTierTwoZombies;

    private int mKilledTierThreeZombies;

    private int mKilledTierFourZombies;

    private int mKilledTierFiveZombies;

    private int mCoinsSpentOnZombies;

    public Zombie(String profileName, int zombieSlayerLevel, int currentZombieExp, int neededZombieExp,
                  int killedTierOneZombies, int killedTierTwoZombies, int killedTierThreeZombies, int killedTierFourZombies, int killedTierFiveZombies, int coinsSpentOnZombies) {

        mSlayerProfileName = profileName;
        mZombieSlayerLevel = zombieSlayerLevel;
        mCurrentZombieExp = currentZombieExp;
        mNeededZombieExp = neededZombieExp;
        mKilledTierOneZombies = killedTierOneZombies;
        mKilledTierTwoZombies = killedTierTwoZombies;
        mKilledTierThreeZombies = killedTierThreeZombies;
        mKilledTierFourZombies = killedTierFourZombies;
        mKilledTierFiveZombies = killedTierFiveZombies;
        mCoinsSpentOnZombies = coinsSpentOnZombies;
    }

    public String getSlayerProfileName() {return mSlayerProfileName;}
    public int getZombieSlayerLevel() {return mZombieSlayerLevel;}
    public int getCurrentZombieExp() {return mCurrentZombieExp;}
    public int getNeededZombieExp() {return mNeededZombieExp;}
    public int getTierOneZombieKills() {return mKilledTierOneZombies;}
    public int getTierTwoZombieKills() {return mKilledTierTwoZombies;}
    public int getTierThreeZombieKills() {return mKilledTierThreeZombies;}
    public int getTierFourZombieKills() {return mKilledTierFourZombies;}
    public int getTierFiveZombieKills() {return mKilledTierFiveZombies;}
    public int getCoinsSpentOnZombies() {return mCoinsSpentOnZombies;}


}
