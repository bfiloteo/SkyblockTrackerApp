package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import com.example.capstoneproject.Profile.ProfileActivity;
import com.example.capstoneproject.Dungeons.DungeonsActivity;
import com.example.capstoneproject.Slayers.SlayerActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class SecondMainActivity extends AppCompatActivity {

    private String passUsername;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private String username;
    private String url = "https://sky.shiiyu.moe/stats/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        // Sets a listener for when the user clicks on an button, it brings them to the corresponding
        // activity.
        setListenerForActivity(findViewById(R.id.DungeonStats), DungeonsActivity.class);
        setListenerForActivity(findViewById(R.id.SlayerStats), SlayerActivity.class);
        setListenerForActivity(findViewById(R.id.ProfileStats), ProfileActivity.class);
    }

    //Creating the method to open the corresponding genre list the user tapped on
    public void setListenerForActivity(View view, final Class activitys){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle retrieveUsername = getIntent().getExtras();
                username = retrieveUsername.getString("Username");
                passUsername = username;
                Intent i = new Intent (SecondMainActivity.this, activitys);
                i.putExtra("retrieveUsername", passUsername);
                startActivityForResult(i, 2);
            }
        });
    }

    // Method that once the "ViewDetailedStats" button has been clicked, it takes the user to the website
    // that holds all of the information about this player
    public void ViewDetailedStats(View v) {
        Bundle retrieveUsername = getIntent().getExtras();
        username = retrieveUsername.getString("Username");
        final String urlWithUsername = (url + username);
        Intent goToInternet = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWithUsername));
        startActivity(goToInternet);
    }

    // Once the user returns from one of the activities to the SecondActivity, it returns the string of the
    // username that was inputted.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                // get String data from Intent
                username = data.getStringExtra("returnUsername");
            }
        }
    }
}