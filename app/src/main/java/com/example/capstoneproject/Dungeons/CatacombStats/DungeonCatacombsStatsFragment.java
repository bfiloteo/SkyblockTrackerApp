package com.example.capstoneproject.Dungeons.CatacombStats;

import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstoneproject.R;

import java.util.List;

import android.content.Intent;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


public class DungeonCatacombsStatsFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<List<DungeonsCatacombsStats>> {


    public DungeonCatacombsStatsFragment() {
    }

    // String for holding the username
    private static String username = "";

    // String to hold the API link for dungeons
    private String DUNGEONS_REQUEST_API = "https://sky.shiiyu.moe/api/v2/dungeons/";

    // String to to hold both the username and the API link
    private String DUNGEON_REQUEST_API_WITH_USERNAME = null;

    // Loader ID
    private static final int DUNGEON_CATACOMBS_LOADER_ID = 1;

    // Adapter
    private DungeonCatacombsStatsAdapter mAdapter;

    // EmptyTextView
    private TextView mEmptyTextView;

    // Loading Indicator
    private View mLoadingIndicator;

    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Defines the intent that was used in the SecondActivity to retrieve the username
        Intent i = getActivity().getIntent();

        // A variable used to retrieve and hold the string value of the username inputted
        String retrieveUsername = i.getStringExtra("retrieveUsername");

        // Adds the username to the API link so the QueryUtils for this corresponding Fragment
        // can look up the stats of this player.
        DUNGEON_REQUEST_API_WITH_USERNAME = (DUNGEONS_REQUEST_API + retrieveUsername);

        // Find a reference to the {@link ListView} in the layout
        ListView statsListView = rootView.findViewById(R.id.list);

        mEmptyTextView = (TextView) rootView.findViewById(R.id.empty_view);
        statsListView.setEmptyView(mEmptyTextView);
        // Create a new adapter that takes an empty list of Dungeon Stats as input
        mAdapter = new DungeonCatacombsStatsAdapter(getActivity(), new ArrayList<>());

        // Finds the LoadingIndicator
        mLoadingIndicator = rootView.findViewById(R.id.loading_indicator);

        // Sets the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        statsListView.setAdapter(mAdapter);

        // Find the SwipeRefreshLayout
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);

        // OnRefreshListener for when the user refreshes the fragment
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                createOrRefreshLoaders();
                Toast.makeText(getActivity(), getString(R.string.updated),
                        Toast.LENGTH_SHORT).show();
            }
        });

        createOrRefreshLoaders();
        return rootView;
    }

    // A method to use to first create the loaders or refresh them when the user refreshes the screen.
    public void createOrRefreshLoaders() {
        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(DUNGEON_CATACOMBS_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            mLoadingIndicator.setVisibility(View.GONE);
            // Update empty state with no connection error message
            mEmptyTextView.setText(R.string.no_internet_connection);
        }
    }


    @Override
    public Loader<List<DungeonsCatacombsStats>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        Uri baseUri = Uri.parse(DUNGEON_REQUEST_API_WITH_USERNAME);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        return new DungeonCatacombStatsLoader(getActivity(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<DungeonsCatacombsStats>> loader, List<DungeonsCatacombsStats> stats) {
        // Hide loading indicator
        mLoadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No Stats found."
        mEmptyTextView.setText("No Stats Found");

        // Clear the adapter of previous stat data
        mAdapter.clear();

        if (stats != null && !stats.isEmpty()) {
            mAdapter.addAll(stats);
        }

        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoaderReset(Loader<List<DungeonsCatacombsStats>> loader) {
        // Loader reset to clean up any existing data.
        mAdapter.clear();
    }
}