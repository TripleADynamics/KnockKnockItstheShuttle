package com.example.andre.knockknockitstheshuttle;
//This is the code for the screen with all of the shuttle stops as options for which locations to update
//https://developers.google.com/maps/documentation/javascript/interaction
//https://developers.google.com/places/android-sdk/intro

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *  Multiple of the same goToMap method for all the different buttons. Methods correspond
     *  in the same order as the xml structure.So 85 Prescott St is goToMap and Faraday Hall is
     *  goToMap 5. The x variable is a holder to essentially listen for what button was pressed.
     *  This variable is placed into the Intent to be extracted in the Map Activity so that it can
     *  go to the proper location
     * @param v maps button click to goToMap functions
     */
    public void goToMap(View v)
    {
        x=1;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }

    public void goToMap1(View v)
    {
        x=2;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }
    public void goToMap2(View v)
    {
        x=3;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }
    public void goToMap3(View v)
    {
        x=4;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }
    public void goToMap4(View v)
    {
        x=5;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }
    public void goToMap5(View v) {
        x=6;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }
    public void goToMap6(View v) {
        x=7;
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        intent.putExtra("MapMove", x);
        startActivity(intent);
    }

}
