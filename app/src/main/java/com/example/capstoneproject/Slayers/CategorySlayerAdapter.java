package com.example.capstoneproject.Slayers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.capstoneproject.Slayers.Zombie.ZombieFragment;
import com.example.capstoneproject.Slayers.Spider.SpiderFragment;
import com.example.capstoneproject.Slayers.Wolf.WolfFragment;

public class CategorySlayerAdapter extends FragmentStateAdapter {


    public CategorySlayerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }


    // Used to retrieve the fragments and have them present on the SlayerActivity
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ZombieFragment();
        } else if (position == 1) {
            return new SpiderFragment();
        } else {
            return new WolfFragment();
        }
    }

    // Returns the 3 fragments
    @Override
    public int getItemCount() {
        return 3;
    }
}