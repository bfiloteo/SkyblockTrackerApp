package com.example.capstoneproject.Slayers.Zombie;

import android.text.TextUtils;
import android.util.Log;

import com.example.capstoneproject.Slayers.Spider.Spider;

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

public final class QueryUtilsForZombie {

    private static final String LOG_TAG = com.example.capstoneproject.Slayers.Zombie.QueryUtilsForZombie.class.getSimpleName();

    private QueryUtilsForZombie() {
    }

    public static List<Zombie> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Zombie> zombieList = extractFeatureFromJson(jsonResponse);

        return zombieList;
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
            Log.e(LOG_TAG, "Problem retrieving the Zombie JSON results.", e);
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


    // Return a list of {@link Spider} objects that has been built up from
    // parsing the given JSON response.
    private static List<Zombie> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats  to
        List<Zombie> zombieElement = new ArrayList<>();

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

                // Finds the JSONObject that holds the the amount of coins that were spent on this slayer.
                JSONObject coinsSpentOnSlayers = currentProfile.getJSONObject("slayer_coins_spent");

                // Finds the JSONObject named "slayers", which holds all of the slayer stats.
                JSONObject slayers = currentProfile.getJSONObject("slayers");

                // Finds the JSONObject named "zombie", which holds all of the slayer stats.
                JSONObject zombies = slayers.getJSONObject("zombie");

                // Finds the JSONObject named "level" which holds the level, current exp, and needed exp
                // for the zombie slayer.
                JSONObject zombieLevel = zombies.getJSONObject("level");

                // Finds the integer that represents the level of slayer.
                int zombieSlayerLevel = zombieLevel.getInt("currentLevel");

                // Assumes that the play has never earned any spider exp.
                int currentZombiesExp = 0;

                // If the player has done a spider slayer, it retrieves the integer named "xp" which
                // represents how the slayer exp.
                if (zombieLevel.has("xp")) {
                    currentZombiesExp = zombieLevel.getInt("xp");
                }

                // Retrieves the integer that represents how many exp the player need.
                // This is always present, whether or not the player has completed any slayers.
                int neededZombiesExp = zombieLevel.getInt("xpForNext");

                // Finds the JSONObject named "kills" which represents the amount of times
                // a player has killed a specific tier of the slayer.
                JSONObject zombieKills = zombies.getJSONObject("kills");

                /** This applies for every tier **/
                // Assumes that each person hasnt killed a specific tier of the slayer, but if the person has killed
                // at least one tier#, it finds the integer that represents the amount of times the player has killed
                // the slayer.
                int tierOneZombieKills = 0;
                if (zombieKills.has("1")) {
                    tierOneZombieKills = zombieKills.getInt("1");
                }

                int tierTwoZombieKills = 0;
                if (zombieKills.has("2")) {
                    tierTwoZombieKills = zombieKills.getInt("2");
                }

                int tierThreeZombieKills = 0;
                if (zombieKills.has("3")) {
                    tierThreeZombieKills = zombieKills.getInt("3");
                }

                int tierFourZombieKills = 0;
                if (zombieKills.has("4")) {
                    tierFourZombieKills = zombieKills.getInt("4");
                }

                int tierFiveZombieKills = 0;
                if (zombieKills.has("5")) {
                    tierFiveZombieKills = zombieKills.getInt("5");
                }

                int coinsSpentOnZombies = 0;
                if (coinsSpentOnSlayers.has("zombie")) {
                    coinsSpentOnZombies = coinsSpentOnSlayers.getInt("zombie");
                }

                // Adds all of the retrieved information into a new Zombie array index.
                Zombie zombieProfileStats = new Zombie(nameOfProfile, zombieSlayerLevel, currentZombiesExp, neededZombiesExp,
                        tierOneZombieKills, tierTwoZombieKills, tierThreeZombieKills, tierFourZombieKills, tierFiveZombieKills, coinsSpentOnZombies);

                // Adds the new array index into the custom adapter
                zombieElement.add(zombieProfileStats);
            }
        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Spider Stats JSON results", e);
        }
        // Return the list of Slayer Stats
        return zombieElement;
    }
}
