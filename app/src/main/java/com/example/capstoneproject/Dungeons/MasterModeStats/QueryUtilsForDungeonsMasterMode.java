package com.example.capstoneproject.Dungeons.MasterModeStats;

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

public final class QueryUtilsForDungeonsMasterMode {

    private static final String LOG_TAG = com.example.capstoneproject.Dungeons.MasterModeStats.QueryUtilsForDungeonsMasterMode.class.getSimpleName();

    private QueryUtilsForDungeonsMasterMode() {
    }

    public static List<DungeonsMasterModeStats> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<DungeonsMasterModeStats> masterModeStats = extractFeatureFromJson(jsonResponse);
        return masterModeStats;
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
    private static List<DungeonsMasterModeStats> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats to
        List<DungeonsMasterModeStats> masterModeStatsElement = new ArrayList<>();

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

            while (keys.hasNext()) {

                // String to hold the randomly generated key.
                String profileID = (String) keys.next();

                // Turns the randomly generated string into a JSONObject since we now know
                // the name of the string.
                JSONObject currentProfile = profileResponse.getJSONObject(profileID);

                // Gets the name of the profile in the randomly generated string.
                String nameOfProfile = currentProfile.getString("cute_name");

                // Gets the JSONObject named "dungeons" which holds all of the user's dungeon stats.
                JSONObject dungeons = currentProfile.getJSONObject("dungeons");

                // Gets the JSONObject named "master_catacombs" in the dungeon's JSONObject
                JSONObject masterMode = dungeons.getJSONObject("master_catacombs");

                // Gets the boolean variable for whether or not the person has visited
                // a MasterMode  floor.
                boolean visitedCatacombs = masterMode.getBoolean("visited");


                // Assumes that the JSONObject "floors" is not present
                JSONObject floors = null;

                /** If **/
                // There is a JSONObject named "floors", it turns floors into that JSONObject.

                /** Else **/
                // Adds a new array index to the custom array, that only holds the profile name,
                // and whether or not the player has visited MasterMode.

                if (masterMode.has("floors")) {

                    /** This applies for every floor **/
                    // Assumes that each person hasn't done a MasterMode floor.
                    floors = masterMode.getJSONObject("floors");
                    JSONObject floorOne = null;
                    JSONObject floorTwo = null;
                    JSONObject floorThree = null;
                    JSONObject floorFour = null;
                    JSONObject floorFive = null;
                    JSONObject floorSix = null;

                    // Assumes that each person hasn't completed a Master Mode floor at least once.
                    int floorOneTimesCompleted = 0;
                    int floorTwoTimesCompleted = 0;
                    int floorThreeTimesCompleted = 0;
                    int floorFourTimesCompleted = 0;
                    int floorFiveTimesCompleted = 0;
                    int floorSixTimesCompleted = 0;

                    // If there is a JSONObject of the corresponding MasterMode floor, it retrieves the JSONObject,
                    // that holds all of the data for that floor. In this case, there would be a JSONObject named
                    // "stats". Afterwards, it finds the int value of how many times the person has completed a MasterMode
                    // floor and sets it to the declared variables above.

                    if (floors.has("1")) {
                        floorOne = floors.getJSONObject("1");
                        JSONObject floorStats = floorOne.getJSONObject("stats");
                        floorOneTimesCompleted = floorStats.getInt("tier_completions");
                    }
                    if (floors.has("2")) {
                        floorTwo = floors.getJSONObject("2");
                        JSONObject floorStats = floorTwo.getJSONObject("stats");
                        floorTwoTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("3")) {
                        floorThree = floors.getJSONObject("3");
                        JSONObject floorStats = floorThree.getJSONObject("stats");
                        floorThreeTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("4")) {
                        floorFour = floors.getJSONObject("4");
                        JSONObject floorStats = floorFour.getJSONObject("stats");
                        floorFourTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("5")) {
                        floorFive = floors.getJSONObject("5");
                        JSONObject floorStats = floorFive.getJSONObject("stats");
                        floorFiveTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    if (floors.has("6")) {
                        floorSix = floors.getJSONObject("6");
                        JSONObject floorStats = floorSix.getJSONObject("stats");
                        floorSixTimesCompleted = floorStats.getInt("tier_completions");
                    }

                    // Adds all of the retrieved information into a new DungeonsMasterMode array index.
                    DungeonsMasterModeStats profileStats = new DungeonsMasterModeStats(
                            nameOfProfile, visitedCatacombs,
                            floorOneTimesCompleted,
                            floorTwoTimesCompleted,
                            floorThreeTimesCompleted,
                            floorFourTimesCompleted,
                            floorFiveTimesCompleted,
                            floorSixTimesCompleted);

                    // Adds the new array index into the custom adapter
                    masterModeStatsElement.add(profileStats);
                } else {
                    DungeonsMasterModeStats profileStats = new DungeonsMasterModeStats(nameOfProfile, visitedCatacombs);
                    masterModeStatsElement.add(profileStats);
                }
            }

        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Master Mode Stats JSON results", e);
        }

        // Return the list of Master Mode Stats
        return masterModeStatsElement;
    }
}
