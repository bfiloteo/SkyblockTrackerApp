package com.example.capstoneproject.Slayers.Spider;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.capstoneproject.R;

import androidx.annotation.NonNull;


import java.text.DecimalFormat;
import java.util.ArrayList;


import android.content.Context;


public class SpiderAdapter extends ArrayAdapter<Spider> {

    public SpiderAdapter(Context context, ArrayList<Spider> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_spider, parent, false);
        }

        final Spider currentStat = getItem(position);


        // Finds the TextView named profileName and sets it to the name that was retrieved in QueryUtilsForSpider.
        TextView profile = listItemView.findViewById(R.id.SpiderProfileName);
        profile.setText(currentStat.getProfileName());

        // Decimal formatter for adding commas to large numbers.
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        // Finds the string resources from the string.xml file
        String currentLevel = getContext().getString(R.string.slayer_level);
        String currentExp = getContext().getString(R.string.current_slayer_exp);
        String neededExp = getContext().getString(R.string.needed_slayer_exp);
        String coinsSpentOnSlayer = getContext().getString(R.string.coins_spent_on_slayers);

        /** This applies for every TextView **/

        // Finds the textview for the corresponding stat (level, current exp, etc) and sets the textview
        // to the number that was retrieved from the QueryUtilsForSpider

        TextView spiderLevel = listItemView.findViewById(R.id.SpiderLevel);
        spiderLevel.setText(currentLevel + (currentStat.getSpiderSlayerLevel()));

        TextView currentSpiderExp = listItemView.findViewById(R.id.CurrentSpiderExp);
        currentSpiderExp.setText(currentExp + formatter.format(currentStat.getCurrentSpiderExp()));

        TextView neededSpiderExp = listItemView.findViewById(R.id.NeededSpiderExp);
        neededSpiderExp.setText(neededExp + formatter.format(currentStat.getNeededSpiderExp()));

        TextView tierOneSpiderKills = listItemView.findViewById(R.id.TierOneSpiderKills);
        tierOneSpiderKills.setText(formatter.format(currentStat.getTierOneSpiderKills()));

        TextView tierTwoSpiderKills = listItemView.findViewById(R.id.TierTwoSpiderKills);
        tierTwoSpiderKills.setText(formatter.format(currentStat.getTierTwoSpiderKills()));

        TextView tierThreeSpiderKills = listItemView.findViewById(R.id.TierThreeSpiderKills);
        tierThreeSpiderKills.setText(formatter.format(currentStat.getTierThreeSpiderKills()));

        TextView tierFourSpiderKills = listItemView.findViewById(R.id.TierFourSpiderKills);
        tierFourSpiderKills.setText(formatter.format((currentStat.getTierFourSpiderKills())));

        TextView coinsSpentOnSpiders= listItemView.findViewById(R.id.CoinsSpentOnSpider);
        coinsSpentOnSpiders.setText(coinsSpentOnSlayer + formatter.format(currentStat.getCoinsSpentSpiders()));

        // Returns the listItemView
        return listItemView;
    }
}