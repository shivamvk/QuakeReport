package com.example.shivamvk.quakereport;


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.util.List;

import static com.example.shivamvk.quakereport.MainActivity.fetchEarthquakeData;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<ListItem>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<ListItem> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<ListItem> result = null;

        try {
            result = fetchEarthquakeData(mUrl);
        } catch (IOException e) {

        }
        return result;
    }
}
