package com.example.capstoneproject.Dungeons.ClassesStats;

import android.annotation.SuppressLint;
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


public class DungeonClassesAdapter extends ArrayAdapter<DungeonClasses> {

    public DungeonClassesAdapter(Context context, ArrayList<DungeonClasses> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_dungeon_classes, parent, false);
        }

        final DungeonClasses currentStat = getItem(position);

        // Strings to display the the level, current exp, and needed exp to level up
        // and the numbers associated with each string.

        String classLevel = getContext().getString(R.string.class_level);

        String currentExp = getContext().getString(R.string.current_class_exp);

        String neededExp = getContext().getString(R.string.needed_class_exp);


        // Decimal formatter to add commas to big numbers
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        // Finds the TextView named profile
        TextView profileName = listItemView.findViewById(R.id.ProfileClass);

        // Sets the TextView to the string that was retrieved from QueryUtilsForDungeonsClasses
        profileName.setText(currentStat.getProfileName());


        /** This applies to all floors **/
        // Finds the textview for the corresponding class stat, and sets the number to the correspoding int
        // that was retrieved from QueryUtilsForDungeonClasses.

            TextView catacombsLevel = listItemView.findViewById(R.id.CatacombsLevel);
            TextView currentCatacombsExp = listItemView.findViewById(R.id.CurrentCatacombsExp);
            TextView neededCatacombsExp = listItemView.findViewById(R.id.NeededCatacombsExp);

            catacombsLevel.setText(classLevel + currentStat.getCatacombsLevel());
            currentCatacombsExp.setText(currentExp + formatter.format(currentStat.getCurrentCatacombsExp()));
            neededCatacombsExp.setText(neededExp + formatter.format(currentStat.getNeededCatacombsExp()));

            TextView archerLevel = listItemView.findViewById(R.id.ArcherLevel);
            TextView currentArcherExp = listItemView.findViewById(R.id.CurrentArcherExp);
            TextView neededArcherExp = listItemView.findViewById(R.id.NeededArcherExp);

            archerLevel.setText(classLevel + currentStat.getArcherLevel());
            currentArcherExp.setText(currentExp + formatter.format(currentStat.getCurrentArcherExp()));
            neededArcherExp.setText(neededExp + formatter.format(currentStat.getNeededArcherExp()));

            TextView berserkerLevel = listItemView.findViewById(R.id.BerserkerLevel);
            TextView currentBerserkerExp = listItemView.findViewById(R.id.CurrentBerserkerExp);
            TextView neededBerserkerExp = listItemView.findViewById(R.id.NeededBerserkerExp);

            berserkerLevel.setText(classLevel + currentStat.getBerserkerLevel());
            currentBerserkerExp.setText(currentExp + formatter.format(currentStat.getCurrentBerserkerExp()));
            neededBerserkerExp.setText(neededExp + formatter.format(currentStat.getNeededBerserkExp()));

            TextView healerLevel = listItemView.findViewById(R.id.HealerLevel);
            TextView currentHealerExp = listItemView.findViewById(R.id.CurrentHealerExp);
            TextView neededHealerExp = listItemView.findViewById(R.id.NeededHealerExp);

            healerLevel.setText(classLevel + currentStat.getHealerLevel());
            currentHealerExp.setText(currentExp + formatter.format(currentStat.getCurrentHealerExp()));
            neededHealerExp.setText(neededExp + formatter.format(currentStat.getNeededHealerExp()));

            TextView mageLevel = listItemView.findViewById(R.id.MageLevel);
            TextView currentMageExp = listItemView.findViewById(R.id.CurrentMageExp);
            TextView neededMageExp = listItemView.findViewById(R.id.NeededMageExp);

            mageLevel.setText(classLevel + currentStat.getMageLevel());
            currentMageExp.setText(currentExp + formatter.format(currentStat.getCurrentMageExp()));
            neededMageExp.setText(neededExp + formatter.format(currentStat.getNeededMageExp()));

            TextView tankLevel = listItemView.findViewById(R.id.TankLevel);
            TextView currentTankExp = listItemView.findViewById(R.id.CurrentTankExp);
            TextView neededTankExp = listItemView.findViewById(R.id.NeededTankExp);

            tankLevel.setText(classLevel + currentStat.getTankLevel());
            currentTankExp.setText(currentExp + formatter.format(currentStat.getCurrentTankExp()));
            neededTankExp.setText(neededExp + formatter.format(currentStat.getNeededTankExp()));

        // Returns the listItemView
        return listItemView;
    }
}
