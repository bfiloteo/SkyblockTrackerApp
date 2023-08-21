package com.example.capstoneproject.Profile.PlayerStats;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.capstoneproject.R;

import androidx.annotation.NonNull;


import java.text.DecimalFormat;
import java.util.ArrayList;


import android.content.Context;


public class PlayerStatsAdapter extends ArrayAdapter<PlayerStats> {

    public PlayerStatsAdapter(Context context, ArrayList<PlayerStats> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_player_stats, parent, false);
        }

        final PlayerStats currentStat = getItem(position);

        // Finds the TextView named profileName and sets it to the name that was retrieved in QueryUtilsForPlayerStats.
        TextView profileName =  listItemView.findViewById(R.id.PlayerStatProfile);
        profileName.setText(currentStat.getProfileName());

        // Decimal formatter for adding commas to large numbers
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        /** This applies for all stats **/
        // Finds the TextView that displays the correspond stat number and sets it to the number
        // that was retrieved in QueryUtilsForPlayerSkills

        TextView health = listItemView.findViewById(R.id.Health);
        health.setText(formatter.format(currentStat.getHealth()));

        TextView strength = listItemView.findViewById(R.id.Strength);
        strength.setText(formatter.format(currentStat.getStrength()));

        TextView defense = listItemView.findViewById(R.id.Defense);
        defense.setText(formatter.format(currentStat.getDefense()));

        TextView speed = listItemView.findViewById(R.id.Speed);
        speed.setText(formatter.format(currentStat.getSpeed()));

        TextView critChance = listItemView.findViewById(R.id.CritChance);
        critChance.setText(formatter.format(currentStat.getCritChance()));

        TextView critDamage = listItemView.findViewById(R.id.CritDamage);
        critDamage.setText(formatter.format(currentStat.getCritDamage()));

        TextView seaCreatureChance = listItemView.findViewById(R.id.SeaCreatureChance);
        seaCreatureChance.setText(formatter.format(currentStat.getSeaCreatureChance()));

        TextView magicFind = listItemView.findViewById(R.id.MagicFind);
        magicFind.setText(formatter.format(currentStat.getMagicFind()));

        TextView ferocity = listItemView.findViewById(R.id.Ferocity);
        ferocity.setText(formatter.format(currentStat.getFerocity()));

        TextView intelligence = listItemView.findViewById(R.id.Intelligence);
        intelligence.setText(formatter.format(currentStat.getIntelligence()));

        // Returns the listItemView
        return listItemView;
    }
}

