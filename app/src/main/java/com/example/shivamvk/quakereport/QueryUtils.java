package com.example.shivamvk.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class QueryUtils {


    private QueryUtils() {}

    public static List<ListItem> extractEarthquakes(String JSONResponse) {

        List<ListItem> earthquakes = new ArrayList<>();

        try {

            JSONObject baseObject = new JSONObject(JSONResponse);
            JSONArray earthquakeArray = baseObject.getJSONArray("features");

            for (int i = 0; i < earthquakeArray.length(); i++){
                JSONObject currentEarthquake = earthquakeArray.getJSONObject(i);
                JSONObject properties = currentEarthquake.getJSONObject("properties");

                double magnitude = properties.getDouble("mag");
                String location = properties.getString("place");
                long time = properties.getLong("time");
                String url = properties.getString("url");

                ListItem earthquake = new ListItem(magnitude, location, time, url);
                earthquakes.add(earthquake);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return earthquakes;
    }

}
