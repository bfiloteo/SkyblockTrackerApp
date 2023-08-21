package com.example.capstoneproject.Dungeons.MasterModeStats;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.capstoneproject.Dungeons.CatacombStats.DungeonsCatacombsStats;
import com.example.capstoneproject.R;

import androidx.annotation.NonNull;


import java.text.DecimalFormat;
import java.util.ArrayList;


import android.content.Context;


public class DungeonsMasterModeAdapter extends ArrayAdapter<DungeonsMasterModeStats> {

    public DungeonsMasterModeAdapter(Context context, ArrayList<DungeonsMasterModeStats> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_dungeons_master_mode_stats, parent, false);
        }

        final DungeonsMasterModeStats currentStat = getItem(position);


        TextView noStatsView = listItemView.findViewById(R.id.NoStatsFound);

        // Decimal formatter for adding commas to large numbers
        DecimalFormat formatter = new DecimalFormat("##,###");

        // Finds the TextView named profileName and sets it to the name that was retrieved in QueryUtilsForDungeonsMasterMode.
        TextView profileName = listItemView.findViewById(R.id.MasterModeProfileName);
        profileName.setText(currentStat.getProfileName());


        /** This applies to all floors **/
        // Finds the TextView from the corresponding floor and the layout of the corresponding floor.

        /** If **/
        // The completions of the corresponding floor equals 0, it sets the layout of the floor to GONE

        /** Else **/
        // Sets the TextView of the corresponding floor completions to the number that was retrieved from
        // QueryUtilsForDungeonsMasterMode

        TextView floorOneCompletions = listItemView.findViewById(R.id.MasterModeFloorOneTimesCompletedNumber);
        RelativeLayout floorOneLayout = listItemView.findViewById(R.id.MasterModeFloorOneLayout);

        if (currentStat.getMasterModeFloorOneCompletions() == 0) {
            floorOneLayout.setVisibility(View.GONE);
            noStatsView.setVisibility(View.VISIBLE);
        } else {
            floorOneCompletions.setText(formatter.format(currentStat.getMasterModeFloorOneCompletions()));
        }
        TextView floorTwoCompletions = listItemView.findViewById(R.id.MasterModeFloorTwoTimesCompletedNumber);
        RelativeLayout floorTwoLayout = listItemView.findViewById(R.id.MasterModeFloorTwoLayout);


        if (currentStat.getMasterModeFloorTwoCompletions() == 0) {
            floorTwoLayout.setVisibility(View.GONE);
        } else {
            floorTwoCompletions.setText(formatter.format(currentStat.getMasterModeFloorTwoCompletions()));
        }

        TextView floorThreeCompletions = listItemView.findViewById(R.id.MasterModeFloorThreeTimesCompletedNumber);
        RelativeLayout floorThreeLayout = listItemView.findViewById(R.id.MasterModeFloorThreeLayout);

        if (currentStat.getMasterModeFloorThreeCompletions() == 0) {
            floorThreeLayout.setVisibility(View.GONE);
        } else {
            floorThreeCompletions.setText(formatter.format(currentStat.getMasterModeFloorThreeCompletions()));
        }

        TextView floorFourCompletions = listItemView.findViewById(R.id.MasterModeFloorFourTimesCompletedNumber);
        RelativeLayout floorFourLayout = listItemView.findViewById(R.id.MasterModeFloorFourLayout);


        if (currentStat.getMasterModeFloorFourCompletions() == 0) {
            floorFourLayout.setVisibility(View.GONE);
        } else {
            floorFourCompletions.setText(formatter.format(currentStat.getMasterModeFloorFourCompletions()));
        }

        TextView floorFiveCompletions = listItemView.findViewById(R.id.MasterModeFloorFiveTimesCompletedNumber);
        RelativeLayout floorFiveLayout = listItemView.findViewById(R.id.MasterModeFloorFiveLayout);

        if (currentStat.getMasterModeFloorFiveCompletions() == 0) {
            floorFiveLayout.setVisibility(View.GONE);
        } else {
            floorFiveCompletions.setText(formatter.format(currentStat.getMasterModeFloorFiveCompletions()));
        }

        TextView floorSixCompletions = listItemView.findViewById(R.id.MasterModeFloorSixTimesCompletedNumber);
        RelativeLayout floorSixLayout = listItemView.findViewById(R.id.MasterModeFloorSixLayout);

        if (currentStat.getMasterModeFloorSixCompletions() == 0) {
            floorSixLayout.setVisibility(View.GONE);
        } else {
            floorSixCompletions.setText(formatter.format(currentStat.getMasterModeFloorSixCompletions()));
        }

        // Returns the listItemView
        return listItemView;
    }
}
