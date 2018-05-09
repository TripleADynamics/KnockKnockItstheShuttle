package com.example.andre.knockknockitstheshuttle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    // Multiple of the same goToMap method for all the different buttons. Methods correspond
    // in the same order as the xml structure.So 85 Prescott St is goToMap and Faraday Hall is
    // goToMap 5. The x variable is a holder to essentially listen for what button was pressed.
    // This variable is placed into the Intent to be extracted in the Map Activity so that it can
    // go to the proper location
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
