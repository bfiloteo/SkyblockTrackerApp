package com.example.capstoneproject.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.capstoneproject.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    TabLayout tabLayout;

    String testingAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the profile_activity_main.xml layout file
        setContentView(R.layout.activity_profile_main);

        Intent i = getIntent();
        testingAgain = i.getStringExtra("TEST");

        // Finds the view pager that will allow the user to swipe between fragments
        final ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpagerForProfiles);
        tabLayout = findViewById(R.id.tabsForProfiles);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryProfileAdapter adapter = new CategoryProfileAdapter(this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Sets up the tabs and names of the tabs
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {

                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0) {
                            tab.setText("Player Stats");
                        } else {
                            tab.setText("Player Skills");
                        }
                    }
                }).attach();
    }

    // Once the user presses the button to go back to the SecondActivity, it sends back the username
    // that was inputted from the MainActivity.
    // This is because originally, you cant use an intent to keep data that was transferred from one
    // to another. In other words, an error would cause that there was no inputted username in the MainActivity,
    // and the views to take the user to the fragments, wouldn't retrieve the data from the inputted username
    public void backToSecondActivityFromProfile(View v) {
        String usernameToPassBack = testingAgain;
        Intent intent = new Intent();
        intent.putExtra("returnUsername", usernameToPassBack);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
