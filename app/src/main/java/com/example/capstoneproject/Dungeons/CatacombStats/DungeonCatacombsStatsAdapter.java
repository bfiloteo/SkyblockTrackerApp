package com.example.capstoneproject.Dungeons.CatacombStats;

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


public class DungeonCatacombsStatsAdapter extends ArrayAdapter<DungeonsCatacombsStats> {

    public DungeonCatacombsStatsAdapter(Context context, ArrayList<DungeonsCatacombsStats> stats) {
        super(context, 0, stats);
    }


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_dungeon_catacombs_stats, parent, false);
        }

        final DungeonsCatacombsStats currentStat = getItem(position);

        // Decimal Formatter to add commas into large numbers
        DecimalFormat formatter = new DecimalFormat("###,###,###");


        //Finds the TextView named profileName from the dungeon_catacombs_stats fragment.
        //Sets the TextView to the name of the profile that was retrieved from the QueryUtils file.
        TextView profileName = listItemView.findViewById(R.id.DungeonProfileName);
        profileName.setText(currentStat.getProfileName());

        TextView noStatsView = listItemView.findViewById(R.id.NoStatsFound);

        /** THIS APPLIES FOR ALL FLOORS **/

        //Finds the TextView for the floor attempts and the floor completions

        TextView entranceAttempts = listItemView.findViewById(R.id.EntranceTimesAttempted);
        TextView entranceCompletions = listItemView.findViewById(R.id.EntranceTimesCompleted);

        //Finds the RelativeLayout for the corresponding floor
        RelativeLayout entranceLayout = listItemView.findViewById(R.id.EntranceLayout);

        /** THIS APPLIES FOR ALL FLOORS**/

        //For every floor, if the attempts that was retrieved for each floor equals 0,
        //it sets the RelativeLayout  of the Floor number to invisible.
        //Else, it sets the TextView of the times attempted and completed to the number that was retrieved from the
        //QueryUtils file, to the corresponding floor. Uses a decimal formatter commas into the numbers.

        if (currentStat.getEntranceAttempts() == 0) {
            entranceLayout.setVisibility(View.GONE);
            noStatsView.setVisibility(View.VISIBLE);
        } else {
            String entranceNumberAttempts = formatter.format(currentStat.getEntranceAttempts());
            String entranceNumberCompletions = formatter.format(currentStat.getEntranceCompletions());
            entranceAttempts.setText(entranceNumberAttempts);
            entranceCompletions.setText(entranceNumberCompletions);
        }


        TextView floorOneAttempts = listItemView.findViewById(R.id.FloorOneTimesAttemptedNumber);
        TextView floorOneCompletions = listItemView.findViewById(R.id.FloorOneTimesCompletedNumber);
        RelativeLayout floorOneLayout = listItemView.findViewById(R.id.FloorOneLayout);


        if (currentStat.getFloorOneAttempts() == 0) {
            floorOneLayout.setVisibility(View.GONE);
        } else {
            String floorOneNumberAttempts = formatter.format(currentStat.getFloorOneAttempts());
            String floorOneNumberCompletions = formatter.format(currentStat.getFloorOneCompletions());
            floorOneAttempts.setText(floorOneNumberAttempts);
            floorOneCompletions.setText(floorOneNumberCompletions);

        }

        TextView floorTwoAttempts = listItemView.findViewById(R.id.FloorTwoTimesAttemptedNumber);
        TextView floorTwoCompletions = listItemView.findViewById(R.id.FloorTwoTimesCompletedNumber);
        RelativeLayout floorTwoLayout = listItemView.findViewById(R.id.FloorTwoLayout);


        if (currentStat.getFloorTwoAttempts() == 0) {
            floorTwoLayout.setVisibility(View.GONE);
        } else {
            String floorTwoNumberAttempts = formatter.format(currentStat.getFloorTwoAttempts());
            String floorTwoNumberCompletions = formatter.format(currentStat.getFloorTwoCompletions());
            floorTwoAttempts.setText(floorTwoNumberAttempts);
            floorTwoCompletions.setText(floorTwoNumberCompletions);

        }

        TextView floorThreeAttempts = listItemView.findViewById(R.id.FloorThreeTimesAttemptedNumber);
        TextView floorThreeCompletions = listItemView.findViewById(R.id.FloorThreeTimesCompletedNumber);
        RelativeLayout floorThreeLayout = listItemView.findViewById(R.id.FloorThreeLayout);


        if (currentStat.getFloorOneAttempts() == 0) {
            floorThreeLayout.setVisibility(View.GONE);
        } else {
            String floorThreeNumberAttempts = formatter.format(currentStat.getFloorThreeAttempts());
            String floorThreeNumberCompletions = formatter.format(currentStat.getFloorThreeCompletions());
            floorThreeAttempts.setText(floorThreeNumberAttempts);
            floorThreeCompletions.setText(floorThreeNumberCompletions);

        }

        TextView floorFourAttempts = listItemView.findViewById(R.id.FloorFourTimesAttemptedNumber);
        TextView floorFourCompletions = listItemView.findViewById(R.id.FloorFourTimesCompletedNumber);
        RelativeLayout floorFourLayout = listItemView.findViewById(R.id.FloorFourLayout);


        if (currentStat.getFloorFourAttempts() == 0) {
            floorFourLayout.setVisibility(View.GONE);
        } else {
            String floorFourNumberAttempts = formatter.format(currentStat.getFloorFourAttempts());
            String floorFourNumberCompletions = formatter.format(currentStat.getFloorFourCompletions());
            floorFourAttempts.setText(floorFourNumberAttempts);
            floorFourCompletions.setText(floorFourNumberCompletions);

        }

        TextView floorFiveAttempts = listItemView.findViewById(R.id.FloorFiveTimesAttemptedNumber);
        TextView floorFiveCompletions = listItemView.findViewById(R.id.FloorFiveTimesCompletedNumber);
        RelativeLayout floorFiveLayout = listItemView.findViewById(R.id.FloorFiveLayout);


        if (currentStat.getFloorFiveAttempts() == 0) {
            floorFiveLayout.setVisibility(View.GONE);
        } else {
            String floorFiveNumberAttempts = formatter.format(currentStat.getFloorFiveAttempts());
            String floorFiveNumberCompletions = formatter.format(currentStat.getFloorFiveCompletions());
            floorFiveAttempts.setText(floorFiveNumberAttempts);
            floorFiveCompletions.setText(floorFiveNumberCompletions);

        }

        TextView floorSixAttempts = listItemView.findViewById(R.id.FloorSixTimesAttemptedNumber);
        TextView floorSixCompletions = listItemView.findViewById(R.id.FloorSixTimesCompletedNumber);
        RelativeLayout floorSixLayout = listItemView.findViewById(R.id.FloorSixLayout);


        if (currentStat.getFloorSixAttempts() == 0) {
            floorSixLayout.setVisibility(View.GONE);
        } else {
            String floorSixNumberAttempts = formatter.format(currentStat.getFloorSixAttempts());
            String floorSixNumberCompletions = formatter.format(currentStat.getFloorSixCompletions());
            floorSixAttempts.setText(floorSixNumberAttempts);
            floorSixCompletions.setText(floorSixNumberCompletions);

        }

        TextView floorSevenAttempts = listItemView.findViewById(R.id.FloorSevenTimesAttemptedNumber);
        TextView floorSevenCompletions = listItemView.findViewById(R.id.FloorSevenTimesCompletedNumber);
        RelativeLayout floorSevenLayout = listItemView.findViewById(R.id.FloorSevenLayout);

        if (currentStat.getFloorSevenAttempts() == 0) {
            floorSevenLayout.setVisibility(View.GONE);
        } else {
            String floorSevenNumberAttempts = formatter.format(currentStat.getFloorSevenAttempts());
            String floorSevenNumberCompletions = formatter.format(currentStat.getFloorSevenCompletions());
            floorSevenAttempts.setText(floorSevenNumberAttempts);
            floorSevenCompletions.setText(floorSevenNumberCompletions);

        }

        // Returns the listItemView
        return listItemView;
    }
}

