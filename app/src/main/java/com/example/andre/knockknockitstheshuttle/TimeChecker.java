package com.example.andre.knockknockitstheshuttle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;

import com.google.maps.model.DistanceMatrix;

public class TimeChecker {
    double lat = 0;
    double lng = 0;
    GoogleMap mMap;

    /*public void distanceMatrix(double lat, double lng, GoogleMap mMap){
        this.lat=lat;
        this.lng=lng;
        this.mMap=mMap;
        Log.d("mainActivity", "Entered distanceMatrix() method");
        // Defines the API key to use
        String API_KEY = "AIzaSyA0LTJc57HImR70w67fJDuw0S09kpu9DKU";
        //Provides context for the matrix
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        // If internet permission is not granted, ask for it
        if (ContextCompat.checkSelfPermission(TimeChecker.this, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            MapActivity.showToastMethod();
            ActivityCompat.requestPermissions((this), new String[]{Manifest.permission.INTERNET}, 1);
        }
        try{
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
            //Takes the approved request and turns it into an actual distance matrix using the users current lat and long,
            // and the recipient's address
            //Matrix takes user's origin as a lat and long value, while it takes the recipients location as a street address
            DistanceMatrix distanceMatrix = req.origins(mMap.getMyLocation().getLatitude() + "," + mMap.getMyLocation().getLongitude()).destinations(lat + "," + lng).await();
            //Takes the duration given by distance matrix and writes it to the global variable finalEstimatedTime
            finalEstimatedTime = ((Long) distanceMatrix.rows[0].elements[0].duration.inSeconds).toString();
            Log.d("mainActivity", "distanceMatrix functions as desired. Final time: " + finalEstimatedTime);
        }
        catch(Exception e){
            Log.d("mainActivity", "Catching things if they fail!");
        }
    }*/
}