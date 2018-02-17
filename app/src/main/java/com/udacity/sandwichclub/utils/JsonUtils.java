package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /*This Method parses the json String to a Sandwich object

    COMPLETED #0
    JSON data is parsed correctly to a Sandwich object in JsonUtils

    COMPLETED #1
    JSON is parsed without using 3rd party libraries
    */

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject name = sandwichJSON.getJSONObject("name");
            JSONArray alsoKnownAsJSON = name.getJSONArray("alsoKnownAs");
            JSONArray ingredientsJSON = sandwichJSON.getJSONArray("ingredients");

            String mainName = name.getString("mainName");

            ArrayList<String> alsoKnownAs = new ArrayList<String>();
            for (int i = 0; i < alsoKnownAsJSON.length(); i++){
                alsoKnownAs.add(alsoKnownAsJSON.getString(i));
            }

            String placeOfOrigin = sandwichJSON.getString("placeOfOrigin");
            String description = sandwichJSON.getString("description");
            String image = sandwichJSON.getString("image");

            ArrayList<String> ingredients = new ArrayList<String>();
            for (int i = 0; i < ingredientsJSON.length(); i++){
                ingredients.add(ingredientsJSON.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
