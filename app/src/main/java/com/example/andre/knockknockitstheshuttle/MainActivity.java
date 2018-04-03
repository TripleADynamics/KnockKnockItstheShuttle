package com.example.andre.knockknockitstheshuttle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Main", "Hey guys its a me a Mario");
        Log.d("Main", "Yeet");

    }
    public void goToMap(View v)
    {
        Intent intent = new Intent(this, MapActivity.class);
        Log.d("MainActivity", "Switching to Map Activity now.");
        startActivity(intent);
    }
}
