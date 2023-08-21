package com.example.capstoneproject.Profile.PlayerSkills;

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

public class PlayerSkillsAdapter extends ArrayAdapter<PlayerSkills> {

    public PlayerSkillsAdapter(Context context, ArrayList<PlayerSkills> stats) {
        super(context, 0, stats);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_player_skills, parent, false);
        }

        final PlayerSkills currentStat = getItem(position);

        // Finds the TextView named profileName and sets it to the name that was retrieved in QueryUtilsForPlayerSkills.
        TextView profileName = listItemView.findViewById(R.id.ProfileSkills);
        profileName.setText(currentStat.getProfileName());

        // Decimal formatter for adding commas to large numbers
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        // Finds the string resources from the string.xml file
        String currentLevel = getContext().getString(R.string.level);
        String currentExp = getContext().getString(R.string.current_exp);
        String neededExp = getContext().getString(R.string.needed_exp);

        /** This applies for all skills **/
        // Finds the TextView for the skill's level, current exp, and needed exp, and set's it to the value
        // that was retrieved in QueryUtilsForPlayerSkills

        TextView tamingLevel = listItemView.findViewById(R.id.TamingLevel);
        tamingLevel.setText(currentLevel + formatter.format(currentStat.getTamingLevel()));

        TextView currentTamingExp = listItemView.findViewById(R.id.CurrentTamingExp);
        currentTamingExp.setText(formatter.format(currentStat.getCurrentTamingExp()));

        TextView neededTamingExp = listItemView.findViewById(R.id.NeededTamingExp);
        neededTamingExp.setText(formatter.format(currentStat.getNeededTamingExp()));

        TextView farmingLevel = listItemView.findViewById(R.id.FarmingLevel);
        farmingLevel.setText(currentLevel + formatter.format(currentStat.getFarmingLevel()));

        TextView currentFarmingExp = listItemView.findViewById(R.id.CurrentFarmingExp);
        currentFarmingExp.setText(currentExp + formatter.format(currentStat.getCurrentFarmingExp()));

        TextView neededFarmingExp = listItemView.findViewById(R.id.NeededFarmingExp);
        neededFarmingExp.setText(neededExp + formatter.format(currentStat.getNeededFarmingExp()));

        TextView miningLevel = listItemView.findViewById(R.id.MiningLevel);
        miningLevel.setText(currentLevel + formatter.format(currentStat.getMiningLevel()));

        TextView currentMiningExp = listItemView.findViewById(R.id.CurrentMiningExp);
        currentMiningExp.setText(currentLevel + formatter.format(currentStat.getCurrentMiningExp()));

        TextView neededMiningExp = listItemView.findViewById(R.id.NeededMiningExp);
        neededMiningExp.setText(neededExp + formatter.format(currentStat.getNeededMiningExp()));

        TextView combatLevel = listItemView.findViewById(R.id.CombatLevel);
        combatLevel.setText(currentLevel + formatter.format(currentStat.getCombatLevel()));

        TextView currentCombatExp = listItemView.findViewById(R.id.CurrentCombatExp);
        currentCombatExp.setText(currentExp + formatter.format(currentStat.getCurrentCombatExp()));

        TextView neededCombatExp = listItemView.findViewById(R.id.NeededCombatExp);
        neededCombatExp.setText(neededExp + formatter.format(currentStat.getNeededCombatExp()));

        TextView foragingLevel = listItemView.findViewById(R.id.ForagingLevel);
        foragingLevel.setText(currentLevel + formatter.format(currentStat.getForagingLevel()));

        TextView currentForagingExp = listItemView.findViewById(R.id.CurrentForagingExp);
        currentForagingExp.setText(currentExp + formatter.format(currentStat.getCurrentForagingExp()));

        TextView neededForagingExp = listItemView.findViewById(R.id.NeededForagingExp);
        neededForagingExp.setText(neededExp + formatter.format(currentStat.getNeededForagingExp()));

        TextView fishingLevel = listItemView.findViewById(R.id.FishingLevel);
        fishingLevel.setText(currentLevel + formatter.format(currentStat.getFishingLevel()));

        TextView currentFishingExp = listItemView.findViewById(R.id.CurrentFishingExp);
        currentFishingExp.setText(currentLevel + formatter.format(currentStat.getCurrentFishingExp()));

        TextView neededFishingExp = listItemView.findViewById(R.id.NeededFishingExp);
        neededFishingExp.setText(neededExp + formatter.format(currentStat.getNeededFishingExp()));

        TextView enchantingLevel = listItemView.findViewById(R.id.EnchantingLevel);
        enchantingLevel.setText(currentLevel + formatter.format(currentStat.getEnchantingLevel()));

        TextView currentEnchantingExp = listItemView.findViewById(R.id.CurrentEnchantingExp);
        currentEnchantingExp.setText(currentExp + formatter.format(currentStat.getCurrentEnchantingExp()));

        TextView neededEnchantingExp = listItemView.findViewById(R.id.NeededEnchantingExp);
        neededEnchantingExp.setText(neededExp + formatter.format(currentStat.getNeededEnchantingExp()));

        TextView alchemyLevel = listItemView.findViewById(R.id.AlchemyLevel);
        alchemyLevel.setText(currentLevel + formatter.format(currentStat.getAlchemyLevel()));

        TextView currentAlchemyExp = listItemView.findViewById(R.id.CurrentAlchemyExp);
        currentAlchemyExp.setText(currentExp + formatter.format(currentStat.getCurrentAlchemyExp()));

        TextView neededAlchemyExp = listItemView.findViewById(R.id.NeededAlchemyExp);
        neededAlchemyExp.setText(neededExp + formatter.format(currentStat.getNeededAlchemyExp()));

        TextView carpentryLevel = listItemView.findViewById(R.id.CarpentryLevel);
        carpentryLevel.setText(currentLevel + formatter.format(currentStat.getCarpentryLevel()));

        TextView currentCarpentryExp = listItemView.findViewById(R.id.CurrentCarpentryExp);
        currentCarpentryExp.setText(currentExp  + formatter.format(currentStat.getCurrentCarpentryExp()));

        TextView neededCarpentryExp = listItemView.findViewById(R.id.NeededCarpentryExp);
        neededCarpentryExp.setText(neededExp + formatter.format(currentStat.getNeededCarpentryExp()));

        TextView runecraftingLevel = listItemView.findViewById(R.id.RunecraftingLevel);
        runecraftingLevel.setText(currentLevel + formatter.format(currentStat.getRunecraftingLevel()));

        TextView currentRunecraftingExp = listItemView.findViewById(R.id.CurrentRunecraftingExp);
        currentRunecraftingExp.setText(currentExp + formatter.format(currentStat.getCurrentRunecraftingExp()));

        TextView neededRunecraftingExp = listItemView.findViewById(R.id.NeededRunecraftingExp);
        neededRunecraftingExp.setText(neededExp + formatter.format(currentStat.getNeededRunecraftingExp()));

        // Returns the listItemView
        return listItemView;
    }
}
