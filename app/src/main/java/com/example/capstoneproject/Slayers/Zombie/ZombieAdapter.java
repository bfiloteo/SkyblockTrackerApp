package com.example.capstoneproject.Slayers.Zombie;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.capstoneproject.Dungeons.MasterModeStats.DungeonsMasterModeStats;
import com.example.capstoneproject.R;
import com.example.capstoneproject.Slayers.Spider.Spider;

import androidx.annotation.NonNull;


import java.text.DecimalFormat;
import java.util.ArrayList;


import android.content.Context;


public class ZombieAdapter extends ArrayAdapter<Zombie> {

    public ZombieAdapter(Context context, ArrayList<Zombie> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_zombie, parent, false);
        }

        final Zombie currentStat = getItem(position);

        TextView profile = listItemView.findViewById(R.id.ZombieProfileName);
        profile.setText(currentStat.getSlayerProfileName());

        DecimalFormat formatter = new DecimalFormat("###,###,###");

        String currentLevel = getContext().getString(R.string.slayer_level);
        String currentExp = getContext().getString(R.string.current_slayer_exp);
        String neededExp = getContext().getString(R.string.needed_slayer_exp);
        String coinsSpentOnSlayer = getContext().getString(R.string.coins_spent_on_slayers);

        TextView zombieLevel = listItemView.findViewById(R.id.ZombieLevel);
        zombieLevel.setText(currentLevel + currentStat.getZombieSlayerLevel());

        TextView currentZombieExp = listItemView.findViewById(R.id.CurrentZombieExp);
        currentZombieExp.setText(currentExp + formatter.format(currentStat.getCurrentZombieExp()));

        TextView neededZombieExp = listItemView.findViewById(R.id.NeededZombieExp);
        neededZombieExp.setText(neededExp + formatter.format(currentStat.getNeededZombieExp()));

        TextView tierOneZombieKills = listItemView.findViewById(R.id.TierOneZombieKills);
        tierOneZombieKills.setText(formatter.format(currentStat.getTierOneZombieKills()));

        TextView tierTwoZombieKills = listItemView.findViewById(R.id.TierTwoZombieKills);
        tierTwoZombieKills.setText(formatter.format(currentStat.getTierTwoZombieKills()));

        TextView tierThreeZombieKills = listItemView.findViewById(R.id.TierThreeZombieKills);
        tierThreeZombieKills.setText(formatter.format(currentStat.getTierThreeZombieKills()));

        TextView tierFourZombieKills = listItemView.findViewById(R.id.TierFourZombieKills);
        tierFourZombieKills.setText(formatter.format(currentStat.getTierFourZombieKills()));

        TextView tierFiveZombieKills = listItemView.findViewById(R.id.TierFiveZombieKills);
        tierFiveZombieKills.setText(formatter.format(currentStat.getTierFiveZombieKills()));

        TextView coinsSpentOnZombies = listItemView.findViewById(R.id.CoinsSpentOnZombies);
        coinsSpentOnZombies.setText(coinsSpentOnSlayer + formatter.format(currentStat.getCoinsSpentOnZombies()));


        // Returns the listItemView
        return listItemView;
    }
}