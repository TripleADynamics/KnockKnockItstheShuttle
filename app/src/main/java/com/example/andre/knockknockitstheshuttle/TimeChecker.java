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
    private String Loc1;
    private String Loc2;
    private String Loc3;
    private String Loc4;
    private String Loc5;
    private String Loc6;
    private String Loc7;

    public TimeChecker(){

    }

    public String getLoc1() {
        return Loc1;
    }

    public void setLoc1(String loc1) {
        Loc1 = loc1;
    }

    public String getLoc2() {
        return Loc2;
    }

    public void setLoc2(String loc2) {
        Loc2 = loc2;
    }

    public String getLoc3() {
        return Loc3;
    }

    public void setLoc3(String loc3) {
        Loc3 = loc3;
    }

    public String getLoc4() {
        return Loc4;
    }

    public void setLoc4(String loc4) {
        Loc4 = loc4;
    }

    public String getLoc5() {
        return Loc5;
    }

    public void setLoc5(String loc5) {
        Loc5 = loc5;
    }

    public String getLoc6() {
        return Loc6;
    }

    public void setLoc6(String loc6) {
        Loc6 = loc6;
    }

    public String getLoc7() {
        return Loc7;
    }

    public void setLoc7(String loc7) {
        Loc7 = loc7;
    }
}