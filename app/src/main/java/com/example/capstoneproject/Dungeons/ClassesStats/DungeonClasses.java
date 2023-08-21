package com.example.capstoneproject.Dungeons.ClassesStats;

public class DungeonClasses {

    // Declaration of variables that will be retrieved from the corresponding QueryUtils

    private String mProfileName;


    private int mCatacombsLevel;

    private int mCurrentCatacombsExp;

    private int mNeededCatacombsExp;

    private int mArcherLevel;

    private int mCurrentArcherExp;

    private int mNeededArcherExp;

    private int mBerserkerLevel;

    private int mCurrentBerserkerExp;

    private int mNeededBerserkerExp;

    private int mHealerLevel;

    private int mCurrentHealerExp;

    private int mNeededHealerExp;

    private int mMageLevel;

    private int mCurrentMageExp;

    private int mNeededMageExp;

    private int mTankLevel;

    private int mCurrentTankExp;

    private int mNeededTankExp;


    //A public method of the class that will hold on the profile name
    // and all stats for all 5 classes and their catacombs stats.
    public DungeonClasses(String ProfileName,
                          int CatacombsLevel, int CurrentCatacombsExp, int NeededCatacombsExp,
                          int ArcherLevel, int CurrentArcherExp, int NeededArcherExp,
                          int BerserkerLevel, int CurrentBerserkerExp, int NeededBerserkerExp,
                          int HealerLevel, int CurrentHealerExp, int NeededHealerExp,
                          int MageLevel, int CurrentMageExp, int NeededMageExp,
                          int TankLevel, int CurrentTankExp, int NeededTankExp) {

        mProfileName = ProfileName;
        mCatacombsLevel = CatacombsLevel;
        mCurrentCatacombsExp = CurrentCatacombsExp;
        mNeededCatacombsExp = NeededCatacombsExp;
        mArcherLevel = ArcherLevel;
        mCurrentArcherExp = CurrentArcherExp;
        mNeededArcherExp = NeededArcherExp;
        mBerserkerLevel = BerserkerLevel;
        mCurrentBerserkerExp = CurrentBerserkerExp;
        mNeededBerserkerExp = NeededBerserkerExp;
        mHealerLevel = HealerLevel;
        mCurrentHealerExp = CurrentHealerExp;
        mNeededHealerExp = NeededHealerExp;
        mMageLevel = MageLevel;
        mCurrentMageExp = CurrentMageExp;
        mNeededMageExp = NeededMageExp;
        mTankLevel = TankLevel;
        mCurrentTankExp = CurrentTankExp;
        mNeededTankExp = NeededTankExp;

    }


    public String getProfileName() {return mProfileName;}

    public int getCatacombsLevel() {return mCatacombsLevel;}

    public int getCurrentCatacombsExp() {return mCurrentCatacombsExp;}

    public int getNeededCatacombsExp() {return mNeededCatacombsExp;}

    public int getArcherLevel() {return mArcherLevel;}

    public int getCurrentArcherExp() {return mCurrentArcherExp;}

    public int getNeededArcherExp() {return mNeededArcherExp;}

    public int getBerserkerLevel() {return mBerserkerLevel;}

    public int getCurrentBerserkerExp() {return mCurrentBerserkerExp;}

    public int getNeededBerserkExp() {return mNeededBerserkerExp;}

    public int getHealerLevel() {return mHealerLevel;}

    public int getCurrentHealerExp() {return mCurrentHealerExp;}

    public int getNeededHealerExp() {return mNeededHealerExp;}

    public int getMageLevel() {return mMageLevel;}

    public int getCurrentMageExp() {return mCurrentMageExp;}

    public int getNeededMageExp() {return mNeededMageExp;}

    public int getTankLevel() {return mTankLevel;}

    public int getCurrentTankExp() {return mCurrentTankExp;}

    public int getNeededTankExp() {return mNeededTankExp;}
}
