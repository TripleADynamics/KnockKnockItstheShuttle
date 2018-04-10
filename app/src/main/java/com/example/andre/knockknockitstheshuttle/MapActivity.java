package com.example.andre.knockknockitstheshuttle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMyLocationButtonClickListener,
        OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    int mapLocation=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Map Entry", "I have entered the onCreate Method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is TRIGGERED when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Bundle takes the x variable from Main Activity and sets it to mapLocation to allow it to
        // move the map camera to the right location.
        Bundle bundle = getIntent().getExtras();
        int mapLocation = bundle.getInt("MapMove");
        //Log.d("Map Activity", Integer.toString(mapLocation));
        mMap = googleMap;
        //Log.d("Map Entry", "I have entered the onMapReady Method");

        // Adds the latitude and longitude values of all the shuttle stops. Latitude and longitude
        // values were found at latlong.net
        LatLng Prescott = new LatLng(42.276106, -71.799932);
        mMap.addMarker(new MarkerOptions().position(Prescott).title("85 Prescott Street"));
        LatLng Bartlett = new LatLng(42.273727,-71.808906);
        mMap.addMarker(new MarkerOptions().position(Bartlett).title("Bartlett Center"));
        LatLng GatewayPark = new LatLng(42.275485,-71.799031);
        mMap.addMarker(new MarkerOptions().position(GatewayPark).title("Gateway Park"));
        LatLng Salisbury = new LatLng(42.279726,-71.807448);
        mMap.addMarker(new MarkerOptions().position(Salisbury).title("Salisbury Estates"));
        LatLng MainBuilding = new LatLng(42.274575,-71.806272);
        mMap.addMarker(new MarkerOptions().position(MainBuilding).title("WPI Main Facility Building"));
        LatLng FaradayHall = new LatLng(42.275159,-71.801032);
        mMap.addMarker(new MarkerOptions().position(FaradayHall).title("Faraday Hall"));

        //Log.d("Map Activity", Integer.toString(mapLocation));

        // Move camera to the right location. The newLatLngZoom also zooms the camera. I found that
        // 17 works well for our purposes but you can change these values.
        if(mapLocation==1) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Prescott, 17));
        }
        else if(mapLocation==2){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bartlett,17));
        }
        else if(mapLocation==3){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GatewayPark,17));
        }
        else if(mapLocation==4){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Salisbury,17));
        }
        else if(mapLocation==5){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MainBuilding,17));
        }
        else if(mapLocation==6){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FaradayHall,17));
        }

        boolean check = checkLocationPermission();
        if(check==false){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
    }
    public boolean checkLocationPermission() {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }
    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

}

