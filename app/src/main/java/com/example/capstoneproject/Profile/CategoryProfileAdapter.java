package com.example.capstoneproject.Profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.capstoneproject.Profile.PlayerStats.PlayerStatsFragment;
import com.example.capstoneproject.Profile.PlayerSkills.PlayerSkillsFragment;


public class CategoryProfileAdapter extends FragmentStateAdapter {


    public CategoryProfileAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    // Used to retrieve the fragments and have them present on the ProfileActivity
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new PlayerStatsFragment();
        } else {
            return new PlayerSkillsFragment();
        }
    }
    // Returns the 2 fragments
    @Override
    public int getItemCount() {
        return 2;
    }
}
