package com.example.capstoneproject.Dungeons.CatacombStats;

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

public final class QueryUtilsForDungeonCatacombs {

    private static final String LOG_TAG = QueryUtilsForDungeonCatacombs.class.getSimpleName();

    private QueryUtilsForDungeonCatacombs() {
    }

    public static List<DungeonsCatacombsStats> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform the HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<DungeonsCatacombsStats> statsList = extractFeatureFromJson(jsonResponse);

        return statsList;
    }


     //Returns new URL object from the given string URL
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

     //Make an HTTP request to the given URL and return a String as the response

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
            Log.e(LOG_TAG, "Problem retrieving the Dungeon JSON results.", e);
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
     // whole JSON response from the server
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

    private static List<DungeonsCatacombsStats> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats  to
        List<DungeonsCatacombsStats> statsElement = new ArrayList<>();

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

                // Gets the JSONObject named "dungeons" which holds all of the user's dungeon stats.
                JSONObject dungeons = currentProfile.getJSONObject("dungeons");

                // Gets the JSONObject named "catacombs" in the dungeon's JSONObject
                JSONObject catacombs = dungeons.getJSONObject("catacombs");

                // Gets the boolean variable for whether or not the person has visited
                // the catacombs
                boolean visitedCatacombs = catacombs.getBoolean("visited");

                // Assumes that the JSONObject "floor" will equal null, because not every profile or player
                // has visited the catacombs.
                JSONObject floors = null;

                // If the player has visited some floors in the dungeons, it finds the JSONObject "floors"
                // and sets it to "floors"
                // Else it only returns the profile name and boolean for whether or not the player's
                // profile has visited the catacombs.
                if (catacombs.has("floors")) {
                    floors = catacombs.getJSONObject("floors");

                    // All are null because we are assuming at first this player's profile
                    // Has not visited this floor.
                    JSONObject entrance = null;
                    JSONObject floorOne = null;
                    JSONObject floorTwo = null;
                    JSONObject floorThree = null;
                    JSONObject floorFour = null;
                    JSONObject floorFive = null;
                    JSONObject floorSix = null;
                    JSONObject floorSeven = null;

                    // Declaration of times played and times completed for each floor.
                    // Assumes 0 because once again, we don't know if this player has visited every
                    // floor at least once.
                    int entranceTimesPlayed = 0;
                    int entranceTimesCompleted = 0;
                    int floorOneTimesPlayed = 0;
                    int floorOneTimesCompleted = 0;
                    int floorTwoTimesPlayed = 0;
                    int floorTwoTimesCompleted = 0;
                    int floorThreeTimesPlayed = 0;
                    int floorThreeTimesCompleted = 0;
                    int floorFourTimesPlayed = 0;
                    int floorFourTimesCompleted = 0;
                    int floorFiveTimesPlayed = 0;
                    int floorFiveTimesCompleted = 0;
                    int floorSixTimesPlayed = 0;
                    int floorSixTimesCompleted = 0;
                    int floorSevenTimesPlayed = 0;
                    int floorSevenTimesCompleted = 0;

                    /** THIS APPLIES TO EVERY FLOOR **/

                    // If the player has the corresponding floor number JSONObject, it will retrieve
                    // the JSONObject of (floor #), find the JSONObject named "stats", (always has one)
                    // and retrieve the amount of times the player has attempted and completed each floor
                    if (floors.has("0")) {
                        entrance = floors.getJSONObject("0");
                        JSONObject floorStats = entrance.getJSONObject("stats");
                        entranceTimesPlayed = floorStats.getInt("times_played");
                        entranceTimesCompleted = floorStats.getInt("tier_completions");
                    }
                    if (floors.has("1")) {
                        floorOne = floors.getJSONObject("1");
                        JSONObject floorStats = floorOne.getJSONObject("stats");
                        floorOneTimesPlayed = floorStats.getInt("times_played");
                        floorOneTimesCompleted = floorStats.getInt("tier_completions");
                    }
                    if (floors.has("2")) {
                        floorTwo = floors.getJSONObject("2");
                        JSONObject floorStats = floorTwo.getJSONObject("stats");
                        floorTwoTimesPlayed = floorStats.getInt("times_played");
                        floorTwoTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("3")) {
                        floorThree = floors.getJSONObject("3");
                        JSONObject floorStats = floorThree.getJSONObject("stats");
                        floorThreeTimesPlayed = floorStats.getInt("times_played");
                        floorThreeTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("4")) {
                        floorFour = floors.getJSONObject("4");
                        JSONObject floorStats = floorFour.getJSONObject("stats");
                        floorFourTimesPlayed = floorStats.getInt("times_played");
                        floorFourTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("5")) {
                        floorFive = floors.getJSONObject("5");
                        JSONObject floorStats = floorFive.getJSONObject("stats");
                        floorFiveTimesPlayed = floorStats.getInt("times_played");
                        floorFiveTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("6")) {
                        floorSix = floors.getJSONObject("6");
                        JSONObject floorStats = floorSix.getJSONObject("stats");
                        floorSixTimesPlayed = floorStats.getInt("times_played");
                        floorSixTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("7")) {
                        floorSeven = floors.getJSONObject("7");
                        JSONObject floorStats = floorSeven.getJSONObject("stats");
                        floorSevenTimesPlayed = floorStats.getInt("times_played");
                        floorSevenTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    // Adds all of the retrieved information into a new DungeonCatacombStats array index.
                    DungeonsCatacombsStats profileStats = new DungeonsCatacombsStats(
                            nameOfProfile, visitedCatacombs,
                            entranceTimesPlayed, entranceTimesCompleted,
                            floorOneTimesPlayed, floorOneTimesCompleted,
                            floorTwoTimesPlayed, floorTwoTimesCompleted,
                            floorThreeTimesPlayed, floorThreeTimesCompleted,
                            floorFourTimesPlayed, floorFourTimesCompleted,
                            floorFiveTimesPlayed, floorFiveTimesCompleted,
                            floorSixTimesPlayed, floorSixTimesCompleted,
                            floorSevenTimesPlayed, floorSevenTimesCompleted);
                    // Adds the new array index into the custom adapter
                    statsElement.add(profileStats);
                } else {
                    DungeonsCatacombsStats profileStats = new DungeonsCatacombsStats(nameOfProfile, visitedCatacombs);
                    statsElement.add(profileStats);
                }
            }

        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Dungeon Stats JSON results", e);
        }

        // Return the list of Stats
        return statsElement;
    }

}