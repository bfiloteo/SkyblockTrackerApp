package com.example.capstoneproject.Dungeons.ClassesStats;

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

public final class QueryUtilsForDungeonClasses {

    private static final String LOG_TAG = com.example.capstoneproject.Dungeons.ClassesStats.QueryUtilsForDungeonClasses.class.getSimpleName();

    private QueryUtilsForDungeonClasses() {
    }

    public static List<DungeonClasses> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<DungeonClasses> classesList = extractFeatureFromJson(jsonResponse);

        return classesList;
    }


    //Returns new URL object from the given string URL.

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }


    //Make an HTTP request to the given URL and return a String as the response.

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

    //Convert the {@link InputStream} into a String which contains the
    //whole JSON response from the server.

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

    //Return a list of {@link DungeonsCatacombsStats} objects that has been built up from
    //parsing the given JSON response.

    private static List<DungeonClasses> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats  to
        List<DungeonClasses> classesElement = new ArrayList<>();

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

                /** This applies to all classes **/

                /**If the the player has visited the catacombs,**/
                // level, currentExp, and neededExp is 0. Then, it finds out if the user has a JSONObject named
                // to the corresponding class. If true, it finds the JSONObject and finds the JSONObject named experience.
                // Inside the JSONObject experience, it finds integers for the level, currentExp, and neededExp for the
                // corresponding class. Additionally, if the user has "maxed" out a class, the JSONResponse turns the value for the
                // neededExp to a null, so I used an optInt method which basically decides that if the int is null, it will return 0.


                JSONObject catacombsStats;
                int catacombsLevel = 0;
                int currentCatacombsExp = 0;
                int neededCatacombsExp = 0;

                if (catacombs.has("level")) {
                    catacombsStats = catacombs.getJSONObject("level");
                    catacombsLevel = catacombsStats.getInt("level");
                    currentCatacombsExp = catacombsStats.getInt("xpCurrent");
                    neededCatacombsExp = catacombsStats.optInt("xpForNext", 0);
                }

                JSONObject classes = dungeons.getJSONObject("classes");

                JSONObject archer;
                int archerLevel;
                int currentArcherExp;
                int neededArcherExp;

                if (classes.has("archer")) {
                    archer = classes.getJSONObject("archer");
                    JSONObject archerStats = archer.getJSONObject("experience");
                    archerLevel = archerStats.getInt("level");
                    currentArcherExp = archerStats.getInt("xpCurrent");
                    neededArcherExp = archerStats.optInt("xpForNext", 0);
                } else {
                    archerLevel = 0;
                    currentArcherExp = 0;
                    neededArcherExp = 0;
                }


                JSONObject berserker;
                int berserkerLevel;
                int currentBerserkerExp;
                int neededBerserkerExp;

                if (classes.has("berserk")) {
                    berserker = classes.getJSONObject("berserk");
                    JSONObject berserkerStats = berserker.getJSONObject("experience");
                    berserkerLevel = berserkerStats.getInt("level");
                    currentBerserkerExp = berserkerStats.getInt("xpCurrent");
                    neededBerserkerExp = berserkerStats.optInt("xpForNext", 0);
                } else {
                    berserkerLevel = 0;
                    currentBerserkerExp = 0;
                    neededBerserkerExp = 0;
                }


                JSONObject healer;
                int healerLevel;
                int currentHealerExp;
                int neededHealerExp;

                if (classes.has("healer")) {
                    healer = classes.getJSONObject("healer");
                    JSONObject healerStats = healer.getJSONObject("experience");
                    healerLevel = healerStats.getInt("level");
                    currentHealerExp = healerStats.getInt("xpCurrent");
                    neededHealerExp = healerStats.optInt("xpForNext", 0);
                } else {
                    healerLevel = 0;
                    currentHealerExp = 0;
                    neededHealerExp = 0;
                }


                JSONObject mage;
                int mageLevel;
                int currentMageExp;
                int neededMageExp;

                if (classes.has("mage")) {
                    mage = classes.getJSONObject("mage");
                    JSONObject mageStats = mage.getJSONObject("experience");
                    mageLevel = mageStats.getInt("level");
                    currentMageExp = mageStats.getInt("xpCurrent");
                    neededMageExp = mageStats.optInt("xpForNext", 0);
                } else {
                    mageLevel = 0;
                    currentMageExp = 0;
                    neededMageExp = 0;
                }

                JSONObject tank;
                int tankLevel;
                int currentTankExp;
                int neededTankExp;

                if (classes.has("tank")) {
                    tank = classes.getJSONObject("tank");
                    JSONObject tankStats = tank.getJSONObject("experience");
                    tankLevel = tankStats.getInt("level");
                    currentTankExp = tankStats.getInt("xpCurrent");
                    neededTankExp = tankStats.optInt("xpForNext", 0);
                } else {
                    tankLevel = 0;
                    currentTankExp = 0;
                    neededTankExp = 0;
                }
                // Adds all of the retrieved information into a new DungeonClasses array index.
                DungeonClasses classesStats = new DungeonClasses(nameOfProfile,
                        catacombsLevel, currentCatacombsExp, neededCatacombsExp,
                        archerLevel, currentArcherExp, neededArcherExp,
                        berserkerLevel, currentBerserkerExp, neededBerserkerExp,
                        healerLevel, currentHealerExp, neededHealerExp,
                        mageLevel, currentMageExp, neededMageExp,
                        tankLevel, currentTankExp, neededTankExp);

                // Adds the new array index into the custom adapter
                classesElement.add(classesStats);
            }

        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Dungeon Stats JSON results", e);
        }

        // Return the list of the Dungeon Class Stats
        return classesElement;
    }

}