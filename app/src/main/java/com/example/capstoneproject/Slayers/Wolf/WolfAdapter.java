package com.example.capstoneproject.Slayers.Wolf;
import com.example.capstoneproject.R;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WolfAdapter extends ArrayAdapter<Wolf> {

    public WolfAdapter(Context context, ArrayList<Wolf> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_wolf, parent, false);
        }

        final Wolf currentStat = getItem(position);

        // Finds the TextView named profileName and sets it to the name that was retrieved in QueryUtilsForWolf.
        TextView profile = listItemView.findViewById(R.id.WolfProfileName);
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
        // to the number that was retrieved from the QueryUtilsForSpider.

        TextView wolfLevel = listItemView.findViewById(R.id.WolfLevel);
        wolfLevel.setText(currentLevel + formatter.format(currentStat.getWolfSlayerLevel()));

        TextView currentWolfExp = listItemView.findViewById(R.id.CurrentWolfExp);
        currentWolfExp.setText(currentExp + formatter.format(currentStat.getCurrentWolfExp()));

        TextView neededWolfExp = listItemView.findViewById(R.id.NeededWolfExp);
        neededWolfExp.setText(neededExp + formatter.format(currentStat.getNeededWolfExp()));

        TextView tierOneWolfKills = listItemView.findViewById(R.id.TierOneWolfKills);
        tierOneWolfKills.setText(formatter.format(currentStat.getTierOneWolfKills()));

        TextView tierTwoWolfKills = listItemView.findViewById(R.id.TierTwoWolfKills);
        tierTwoWolfKills.setText(formatter.format(currentStat.getTierTwoWolfKills()));

        TextView tierThreeWolfKills = listItemView.findViewById(R.id.TierThreeWolfKills);
        tierThreeWolfKills.setText(formatter.format(currentStat.getTierThreeWolfKills()));

        TextView tierFourWolfKills = listItemView.findViewById(R.id.TierFourWolfKills);
        tierFourWolfKills.setText(formatter.format(currentStat.getTierFourWolfKills()));

        TextView coinsSpentOnWolves = listItemView.findViewById(R.id.CoinsSpentOnWolves);
        coinsSpentOnWolves.setText(coinsSpentOnSlayer + formatter.format(currentStat.getCoinsSpentOnWolves()));

        // Returns the listItemView
        return listItemView;
    }
}
