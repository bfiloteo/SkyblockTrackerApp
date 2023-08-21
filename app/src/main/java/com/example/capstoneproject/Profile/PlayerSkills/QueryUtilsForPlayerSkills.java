package com.example.capstoneproject.Profile.PlayerSkills;

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

public final class QueryUtilsForPlayerSkills {

    private static final String LOG_TAG = com.example.capstoneproject.Profile.PlayerSkills.QueryUtilsForPlayerSkills.class.getSimpleName();

    private QueryUtilsForPlayerSkills() {
    }

    public static List<PlayerSkills> fetchStatData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<PlayerSkills> skillList = extractFeatureFromJson(jsonResponse);

        return skillList;
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
            Log.e(LOG_TAG, "Problem retrieving the Player Skills JSON results.", e);
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

    // Return a list of {@link PlayerSkills} objects that has been built up from
    // parsing the given JSON response.
    private static List<PlayerSkills> extractFeatureFromJson(String statsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(statsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding stats to
        List<PlayerSkills> skillsElement = new ArrayList<>();

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

                // Finds the JSONObject named "data" which holds the player's stats.
                JSONObject data = currentProfile.getJSONObject("data");

                // Finds the JSONObject named "levels" which is basically the player's skills.
                JSONObject levels = data.getJSONObject("levels");

                /** This applies for all skills except carpentry and runecrafitng **/
                // Finds the JSONObject of for the name of the skill and finds the integer values
                // for the skills' level, current exp, and needed exp.
                // optInt is used for the needed exp, in case the user has reached the max skill level.

                JSONObject tamingStats = levels.getJSONObject("taming");
                int tamingLevel = tamingStats.getInt("level");
                int currentTamingExp = tamingStats.getInt("xpCurrent");
                int neededTamingExp = tamingStats.optInt("xpForNext", 0);

                JSONObject farmingStats = levels.getJSONObject("farming");
                int farmingLevel = farmingStats.getInt("level");
                int currentFarmingExp = farmingStats.getInt("xpCurrent");
                int neededFarmingExp = farmingStats.optInt("xpForNext", 0);

                JSONObject miningStats = levels.getJSONObject("mining");
                int miningLevel = miningStats.getInt("level");
                int currentMiningExp = miningStats.getInt("xpCurrent");
                int neededMiningExp = miningStats.optInt("xpForNext", 0);

                JSONObject combatStats = levels.getJSONObject("combat");
                int combatLevel = combatStats.getInt("level");
                int currentCombatExp = combatStats.getInt("xpCurrent");
                int neededCombatExp = combatStats.optInt("xpForNext", 0);

                JSONObject foragingStats = levels.getJSONObject("foraging");
                int foragingLevel = foragingStats.getInt("level");
                int currentForagingExp = foragingStats.getInt("xpCurrent");
                int neededForgaingExp = foragingStats.optInt("xpForNext", 0);

                JSONObject fishingStats = levels.getJSONObject("fishing");
                int fishingLevel = fishingStats.getInt("level");
                int currentFishingExp = fishingStats.getInt("xpCurrent");
                int neededFishingExp = fishingStats.optInt("xpForNext", 0);

                JSONObject enchantingStats = levels.getJSONObject("enchanting");
                int enchantingLevel = enchantingStats.getInt("level");
                int currentEnchantingExp = enchantingStats.getInt("xpCurrent");
                int neededEnchantingExp = enchantingStats.optInt("xpForNext", 0);

                JSONObject alchemyStats = levels.getJSONObject("alchemy");
                int alchemyLevel = alchemyStats.getInt("level");
                int currentAlchemyExp = alchemyStats.getInt("xpCurrent");
                int neededAlchemyExp = alchemyStats.optInt("xpForNext", 0);


                /** This applies for carpentry and runecrafting **/
                // These skills work in a different way than the other skills since their stats don't show
                // on a different profile. In this case, I declared the level, current exp, and needed exp
                // to zero, and code to where if there is a JSONObject named "carpentry" or "runecrafting",
                // it retrieves the JSONObject, the JSONObject named "level" inside of it, and retrieves the
                // level, current exp, and needed exp.
                int carpentryLevel = 0;
                int currentCarpentryExp = 0;
                int neededCarpentryExp = 0;
                if (levels.has("carpentry")) {
                    JSONObject carpentryStats = levels.getJSONObject("carpentry");
                    carpentryLevel = carpentryStats.getInt("level");
                    currentCarpentryExp = carpentryStats.getInt("xpCurrent");
                    neededCarpentryExp = carpentryStats.optInt("xpForNext", 0);
                }

                int runecraftingLevel = 0;
                int currentRunecraftingExp = 0;
                int neededRunecraftingExp = 0;

                if(levels.has("runecrafting")) {
                    JSONObject runecraftingStats = levels.getJSONObject("runecrafting");
                    runecraftingLevel = runecraftingStats.getInt("level");
                    currentRunecraftingExp = runecraftingStats.getInt("xpCurrent");
                    neededRunecraftingExp = runecraftingStats.optInt("xpForNext", 0);
                }

                // Adds all of the retrieved information into a new PlayerSkill array index.
                PlayerSkills playerSkills = new PlayerSkills(nameOfProfile,
                        tamingLevel, currentTamingExp, neededTamingExp,
                        farmingLevel, currentFarmingExp, neededFarmingExp,
                        miningLevel, currentMiningExp, neededMiningExp,
                        combatLevel, currentCombatExp, neededCombatExp,
                        foragingLevel, currentForagingExp, neededForgaingExp,
                        fishingLevel, currentFishingExp, neededFishingExp,
                        enchantingLevel, currentEnchantingExp, neededEnchantingExp,
                        alchemyLevel, currentAlchemyExp, neededAlchemyExp,
                        carpentryLevel, currentCarpentryExp, neededCarpentryExp,
                        runecraftingLevel, currentRunecraftingExp, neededRunecraftingExp);

                // Adds the new array index into the custom adapter
                skillsElement.add(playerSkills);
            }

        } catch (
                JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Dungeon Stats JSON results", e);
        }

        // Return the list of the Player Skill Stats
        return skillsElement;
    }
}

