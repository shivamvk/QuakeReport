package com.example.shivamvk.quakereport;

public class ListItem {

    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;

    public ListItem(double magnitude, String location, long date, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }

    public double getmMagnitude(){
        return mMagnitude;
    }

    public String getmLocation(){
        return mLocation;
    }

    public long getmDate(){
        return mDate;
    }

    public String getmUrl(){
        return mUrl;
    }
}
