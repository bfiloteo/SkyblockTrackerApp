package com.example.capstoneproject.Profile.PlayerStats;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public final class QueryUtilsForPlayerStats {

    private static final String LOG_TAG = com.example.capstoneproject.Profile.PlayerStats.QueryUtilsForPlayerStats.class.getSimpleName();

    private QueryUtilsForPlayerStats() {
    }

    public static List<PlayerStats> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<PlayerStats> statsList = extractFeatureFromJson(jsonResponse);

        return statsList;
    }


    // Returns new URL object from the given string URL.
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    // Make an HTTP request to the given URL and return a String as the response.

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the News JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    // Convert the {@link InputStream} into a String which contains the
    // whole JSON response from the server.

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    // Return a list of {@link DungeonsCatacombsStats} objects that has been built up from
    // parsing the given JSON response.
    private static List<PlayerStats> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats to
        List<PlayerStats> statsElement = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.

        try {

            JSONObject baseJsonResponse = new JSONObject(statsJSON);

            // Finds the JSONObject named "profiles" which holds the entire JSON response
            JSONObject profileResponse = baseJsonResponse.getJSONObject("profiles");

            // Each profile has a different randomly generated string of numbers and letters.
            // I'm using an iterator to help figure out what the string is
            Iterator<String> keys = profileResponse.keys();

            // While profileResponse has at least one randomly generated string, this will move onto the
            // next string in profileResponse to retrieve the name
            while (keys.hasNext()) {

                // String to hold the randomly generated string
                String profileID = (String) keys.next();

                // Turns the randomly generated string into a JSONObject since we now know
                // the name of the string.
                JSONObject currentProfile = profileResponse.getJSONObject(profileID);

                // Gets the name of the profile in the randomly generated string.
                String nameOfProfile = currentProfile.getString("cute_name");

                // Finds the JSONObject named "data" which holds the player's stats.
                JSONObject data = currentProfile.getJSONObject("data");

                // Finds the JSONObject named "levels" which is basically the player's current stats.
                JSONObject stats = data.getJSONObject("stats");

                /** This applies for every stat **/
                // Retrieves the number for each associated stat

                int health = stats.getInt("health");

                int strength = stats.getInt("strength");

                int defense = stats.getInt("defense");

                int speed = stats.getInt("speed");

                int intelligence = stats.getInt("intelligence");

                int magicFind = stats.getInt("magic_find");

                int ferocity = stats.getInt("ferocity");

                int critChance = stats.getInt("crit_chance");

                int critDamage = stats.getInt("crit_damage");

                int seaCreatureChance = stats.getInt("sea_creature_chance");

                // Adds all of the retrieved information into a new PlayerStat array index.
                PlayerStats playerStats = new PlayerStats(nameOfProfile, health, strength, defense,
                        speed, intelligence, seaCreatureChance, magicFind, ferocity, critChance, critDamage);
                // Adds the new array index into the custom adapter
                statsElement.add(playerStats);
            }

        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Player Stats JSON results", e);
        }
        // Return the list of Player Stats
        return statsElement;
    }
}