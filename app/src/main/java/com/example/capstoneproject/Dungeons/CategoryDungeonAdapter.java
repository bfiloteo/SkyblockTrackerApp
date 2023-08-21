package com.example.capstoneproject.Dungeons;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.capstoneproject.Dungeons.CatacombStats.DungeonCatacombsStatsFragment;
import com.example.capstoneproject.Dungeons.ClassesStats.DungeonClassesFragment;
import com.example.capstoneproject.Dungeons.MasterModeStats.DungeonsMasterModeStatsFragment;

public class CategoryDungeonAdapter extends FragmentStateAdapter {


    public CategoryDungeonAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }


    // Used to retrieve the fragments and have them present on the DungeonsActivity
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new DungeonCatacombsStatsFragment();
        } else if (position == 1) {
            return new DungeonClassesFragment();
        } else {
            return new DungeonsMasterModeStatsFragment();
        }
    }
    // Returns the 3 fragments
    @Override
    public int getItemCount() {
        return 3;
    }
}