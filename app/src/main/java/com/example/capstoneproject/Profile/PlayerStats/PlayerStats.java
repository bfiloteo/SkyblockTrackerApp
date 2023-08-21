package com.example.capstoneproject.Profile.PlayerStats;


public class PlayerStats {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils

    private String mProfileName;

    private int mHealth;

    private int mStrength;

    private int mDefense;

    private int mSpeed;

    private int mIntelligence;

    private int mSeaCreatureChance;

    private int mMagicFind;

    private int mCritChance;

    private int mCritDamage;

    private int mFerocity;

    // A public method of the class that will hold on the profile name and current number for each
    // stat.

    public PlayerStats(String profileName, int health, int strength, int defense, int speed,
                       int intelligence, int seaCreatureChance, int magicFind, int critChance, int critDamage, int ferocity) {
        mProfileName = profileName;
        mHealth = health;
        mStrength = strength;
        mDefense = defense;
        mSpeed = speed;
        mIntelligence = intelligence;
        mSeaCreatureChance = seaCreatureChance;
        mMagicFind = magicFind;
        mCritChance = critChance;
        mCritDamage = critDamage;
        mFerocity = ferocity;
    }

    // Public methods that will return the information from the corresponding QueryUtils
    // And apply these values into the corresponding Adapter.
    public String getProfileName() {return mProfileName;}

    public int getHealth() {return mHealth; }

    public int getStrength() {return mStrength;}

    public int getDefense() {return mDefense;}

    public int getSpeed() {return mSpeed;}

    public int getIntelligence() {return mIntelligence;}

    public int getSeaCreatureChance() {return mSeaCreatureChance;}

    public int getMagicFind() {return mMagicFind;}

    public int getCritChance() {return mCritChance;}

    public int getCritDamage() {return mCritDamage;}

    public int getFerocity() {return mFerocity;}


}
